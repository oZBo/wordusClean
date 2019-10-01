package com.braincollaboration.wordus.ui.screens.main

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.braincollaboration.wordus.R
import com.braincollaboration.wordus.feature.home.WordsViewModel
import com.braincollaboration.wordus.feature.home.api.WordRepository
import com.braincollaboration.wordus.feature.home.api.WordService
import com.braincollaboration.wordus.feature.home.interactor.GetWords
import com.braincollaboration.wordus.ui.screens.base.activity.BaseActivity
import retrofit2.Retrofit

class MainActivity : BaseActivity(R.layout.activity_main) {

    private val viewModel: WordsViewModel by viewModels()
//    todo implement factory
//        WordsViewModel.ViewModelFactory(
//            GetWords(
//                WordRepository.Network(WordService(Retrofit()))
//            )
//        )
//    )

    override fun initViews() {
        viewModel.words.observe(this) {
            Log.i("duck", "inside")
        }
    }

}