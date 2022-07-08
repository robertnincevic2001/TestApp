package com.example.testapp.ui.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.R
import com.example.testapp.ui.game.GameActivity
import com.example.testapp.data.model.retrofitmodels.GameDto
import com.example.testapp.databinding.ItemTodoBinding
import com.example.testapp.utils.Constants

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    private var context: Context? = null

    var GameDtos: List<GameDto> = emptyList()

    override fun getItemCount() = GameDtos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        context = parent.context

        return TodoViewHolder(ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    fun setAdapter (list: List<GameDto>?){
        list ?: return
        GameDtos = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        holder.binding.apply {
            val todo = GameDtos[position]
            tvTitle.text = todo.title
            tvTitle2.text = todo.genre
            linkID.text = todo.gameUrl

            context?.let {
                Glide.with(it)
                    .load(todo.thumbnail)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(gameImage)
            }

            if(todo.visibility == true){
                linkID.visibility = View.VISIBLE
                buttonID.visibility = View.VISIBLE
            }
            else{
                linkID.visibility = View.GONE
                buttonID.visibility = View.GONE
            }
            root.setOnClickListener{

                if(todo.visibility == true){
                    todo.visibility = false
                    notifyItemChanged(position)

                }
                else{
                    val oldPosition = GameDtos.indexOfFirst {
                        it.visibility == true
                    }
                    if(oldPosition != -1){
                        GameDtos[oldPosition].visibility = false
                        notifyItemChanged(oldPosition)
                    }
                    todo.visibility = true
                    notifyItemChanged(position)
                }
            }

            buttonID.setOnClickListener{
                val intent = Intent(context, GameActivity::class.java).apply {
                    putExtra(Constants.GAME_ID, todo.id)
                }
                context?.startActivity(intent)
            }

            linkID.setOnClickListener{
                val openURL = Intent(android.content.Intent.ACTION_VIEW)
                if(linkID.text != "" && linkID.text != null){
                    openURL.data = Uri.parse(linkID.text.toString())
                    context?.startActivity(openURL)
                }
                else{
                    context?.let{ ctx->
                        Toast.makeText(ctx, "ERROR, krivi link", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}