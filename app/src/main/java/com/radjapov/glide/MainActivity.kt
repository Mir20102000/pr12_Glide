package com.radjapov.glide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.radjapov.glide.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var imageUrl: String

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        imageUrl = savedInstanceState?.getString(KEY_IMAGE_URL) ?: imageList[Random.nextInt(imageList.size)]

        Glide.with(this)
            .load(imageUrl)
            .into(binding.imageView)
    }

    companion object {
        const val KEY_IMAGE_URL = "KEY_IMAGE_URL"
        val imageList = listOf(
            "https://images.unsplash.com/photo-1653740559117-641ebb2e2084?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=327&q=80",
            "https://images.unsplash.com/photo-1653314622658-4a34c996b410?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80",
            "https://images.unsplash.com/photo-1653693010141-3546e0f80123?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"
        )
    }
}