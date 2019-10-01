package com.braincollaboration.wordus.feature.home.api

import com.braincollaboration.wordus.BuildConfig
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface WordMeaningApi {

    companion object {

        private const val WORD = "word"
        private const val DICTIONARY_ID = 1049
        private const val SEARCH_ZONE = 1
        private const val START_INDEX = 0
        private const val PAGE_SIZE = 4

        private const val GET_WORD_MEANING = "api/v1/Search?text={$WORD}&srcLang={$DICTIONARY_ID}" +
                "&dstLang={$DICTIONARY_ID}&searchZone={$SEARCH_ZONE}&startIndex={$START_INDEX}&pageSize={$PAGE_SIZE}"
    }

    @Headers("Authorization: Basic ${BuildConfig.ABYY_APP_KEY}")
    @POST("api/v1.1/authenticate")
    fun getBasicToken(): Call<ResponseBody>

    @GET(GET_WORD_MEANING)
    fun getWordMeaning(@Path(WORD) word: String): Call<String>

}