package com.example.androidapparchitecture

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidapparchitecture.databinding.ActivityMainBinding
import com.example.androidapparchitecture.mvp.view.MvpActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()

        setupClickListeners()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setupClickListeners() {
        binding.btnMvp.setOnClickListener {
            val mvpIntent = Intent(this, MvpActivity::class.java)
            startActivity(mvpIntent)
        }
    }
}