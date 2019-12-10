package com.braincollaboration.wordus.presentation.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.braincollaboration.wordus.data.room.wordTable.WordRoomModel
import com.braincollaboration.wordus.domain.viewmodel.BaseViewModel
import com.braincollaboration.wordus.domain.usecase.base.UseCase
import com.braincollaboration.wordus.domain.usecase.GetWordsUseCase

class WordsViewModel(private val getWords: GetWordsUseCase) : BaseViewModel() {

    private val _words = MutableLiveData<List<WordRoomModel>>()

    val words: LiveData<List<WordRoomModel>> = liveData(viewModelScope.coroutineContext) {
        val words = getWords(UseCase.None)
        _words.value = words.get(emptyList())
        emitSource(_words)
    }

}