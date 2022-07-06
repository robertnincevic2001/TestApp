package com.example.testapp.ui.game

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.R
import com.example.testapp.data.model.retrofitmodels.Screenshot
import com.example.testapp.databinding.GameRecyclerviewItemBinding

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(val binding: GameRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root)

    private var context: Context? = null

    var images: List<Screenshot> = emptyList()

    fun setAdapter (list: List<Screenshot>?){
        list ?: return
        images = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {

        context = parent.context

        return ImageViewHolder(GameRecyclerviewItemBinding.inflate(

            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.binding.apply {
            val image = images[position]


            context?.let {
                Glide.with(it)
                    .load(image.image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(recyclerImageView)
            }


        }
    }

    override fun getItemCount() = images.size

}