package com.braincollaboration.wordus.feature.home.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface WordMeaningApi {

    companion object {

        private const val WORD_ID = "wordId"

        private const val GET_WORD_MEANING = "dictionary/endpoint/findWord/{$WORD_ID}" /*TODO correctEndpoint*/
    }

    @GET(GET_WORD_MEANING)
    fun getWordMeaning(@Path(WORD_ID) wordId : String) : Call<String>

}