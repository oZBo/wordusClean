package com.braincollaboration.wordus.feature.home

import androidx.lifecycle.*
import com.braincollaboration.wordus.base.domain.viewmodel.BaseViewModel
import com.braincollaboration.wordus.base.interactor.UseCase
import com.braincollaboration.wordus.feature.home.interactor.GetWords
import com.braincollaboration.wordus.feature.home.view.WordPresentation

class WordsViewModel(private val getWords: GetWords) : BaseViewModel() {

    private val _words = MutableLiveData<List<WordPresentation>>()

    val words: LiveData<List<WordPresentation>> = liveData(viewModelScope.coroutineContext) {
        val words = getWords(UseCase.None)
        _words.value = words.get(emptyList())
        emitSource(_words)
    }

    class ViewModelFactory(private var getWords: GetWords) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return WordsViewModel(getWords) as T
        }

    }

}