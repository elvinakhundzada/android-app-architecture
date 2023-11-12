package com.example.androidapparchitecture

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidapparchitecture.databinding.ActivityMainBinding
import com.example.androidapparchitecture.mvi.view.MviActivity
import com.example.androidapparchitecture.mvp.view.MvpActivity
import com.example.androidapparchitecture.mvvm.view.MvvmActivity

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

        binding.btnMvvm.setOnClickListener {
            val mvpIntent = Intent(this, MvvmActivity::class.java)
            startActivity(mvpIntent)
        }

        binding.btnMvi.setOnClickListener {
            val mviIntent = Intent(this, MviActivity::class.java)
            startActivity(mviIntent)
        }
    }
}