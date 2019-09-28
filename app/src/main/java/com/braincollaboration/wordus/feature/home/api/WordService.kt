package com.braincollaboration.wordus.feature.home.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit

class WordService constructor(retrofit: Retrofit) : WordMeaningApi {

    private val wordApi by lazy { retrofit.create(WordMeaningApi::class.java) }

    override fun getWordMeaning(word: String): Call<String> = wordApi.getWordMeaning(word)

    override fun getBasicToken(): Call<ResponseBody> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}