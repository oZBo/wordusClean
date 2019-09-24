package com.braincollaboration.wordus.feature.home.api

import retrofit2.Call
import retrofit2.Retrofit


class WordService constructor(retrofit: Retrofit) : WordMeaningApi {

    private val wordApi by lazy { retrofit.create(WordMeaningApi::class.java) }

    override fun getWordMeaning(wordId: String): Call<String> = wordApi.getWordMeaning(wordId)
}