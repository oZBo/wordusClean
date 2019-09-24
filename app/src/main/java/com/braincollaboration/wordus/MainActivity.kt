package com.braincollaboration.wordus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.braincollaboration.wordus.feature.home.WordsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : WordsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}
