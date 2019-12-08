package com.braincollaboration.wordus.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.braincollaboration.wordus.base.domain.viewmodel.BaseViewModel
import com.braincollaboration.wordus.base.interactor.UseCase
import com.braincollaboration.wordus.feature.home.interactor.GetWordsUseCase
import com.braincollaboration.wordus.feature.home.view.WordPresentation

class WordsViewModel(private val getWords: GetWordsUseCase) : BaseViewModel() {

    private val _words = MutableLiveData<List<WordPresentation>>()

    val words: LiveData<List<WordPresentation>> = liveData(viewModelScope.coroutineContext) {
        val words = getWords(UseCase.None)
        _words.value = words.get(emptyList())
        emitSource(_words)
    }

}