package com.braincollaboration.wordus.presentation.screens.main

import android.util.Log
import androidx.lifecycle.observe
import com.braincollaboration.wordus.R
import com.braincollaboration.wordus.presentation.screens.WordsViewModel
import com.braincollaboration.wordus.presentation.screens.base.activity.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(R.layout.activity_main) {

    private val viewModel: WordsViewModel by viewModel()

    override fun initViews() {
        viewModel.words.observe(this) {
            Log.i("duck", "inside")
        }
    }

}