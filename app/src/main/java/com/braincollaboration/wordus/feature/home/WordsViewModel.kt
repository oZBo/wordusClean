package com.braincollaboration.wordus.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.braincollaboration.wordus.base.interactor.UseCase
import com.braincollaboration.wordus.feature.home.interactor.GetWords
import com.braincollaboration.wordus.feature.home.view.WordPresentation
import org.dipocket.core.clean.base.domain.viewmodel.BaseViewModel

class WordsViewModel(private val getWords: GetWords) : BaseViewModel() {

    private val _words = MutableLiveData<List<WordPresentation>>()

    val words: LiveData<List<WordPresentation>> = liveData(viewModelScope.coroutineContext) {
        val words = getWords(UseCase.None)
        _words.value = words.get(emptyList())
        emitSource(_words)
    }

}