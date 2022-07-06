package com.example.testapp.ui.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.testapp.ui.main.MainActivity
import com.example.testapp.databinding.ActivityGameBinding
import com.example.testapp.utils.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameActivity : AppCompatActivity() {

    private lateinit var binding : ActivityGameBinding

    private val viewModel : GameViewModel by viewModel()

    private var imageAdapter: ImageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        val gameID = intent.getIntExtra(Constants.GAME_ID, -1)

        viewModel.getGameData(gameID)

        viewModel.dataSuccess.observe(this, Observer{
            it ?: return@Observer

            imageAdapter?.setAdapter(it.screenshots)

            binding.gameTitle.text = it.title
            binding.gameGenre.text = it.genre
            binding.gamePlatform.text = it.platform
            binding.gameShortDescription.text = it.shortDescription

            binding.backButtonID.setOnClickListener {
                val intent = Intent(this@GameActivity, MainActivity::class.java)
                startActivity(intent)
            }

            Glide.with(this@GameActivity)
                .load(it.thumbnail)
                .into(binding.imageView)

        })

        viewModel.dataFailure.observe(this, Observer {
            it ?: return@Observer

            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })


    }

    private fun setupRecyclerView() {
        imageAdapter = ImageAdapter()
        binding.imagerecyclerView.adapter = imageAdapter
    }
}