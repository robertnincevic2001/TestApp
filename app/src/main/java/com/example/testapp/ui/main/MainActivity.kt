package com.example.testapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer

import com.example.testapp.databinding.ActivityMainBinding

import org.koin.androidx.viewmodel.ext.android.viewModel

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel : MainViewModel by viewModel()

    private var todoAdapter: TodoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        binding.progressBar.isVisible = true

        viewModel.getGames()

        viewModel.dataSuccess.observe(this@MainActivity, Observer {
            it ?: return@Observer

            todoAdapter?.setAdapter(it)
            binding.progressBar.isVisible = false

        })

        viewModel.dataFailure.observe(this, Observer {
            it?: return@Observer

            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
            binding.progressBar.isVisible = false

        })
    }

    private fun setupRecyclerView() {
        todoAdapter = TodoAdapter()
        binding.rvTodos.adapter = todoAdapter
    }
}