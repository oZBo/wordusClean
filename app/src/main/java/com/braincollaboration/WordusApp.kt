package com.braincollaboration

import android.app.Application
import retrofit2.Retrofit


class WordusApp : Application() {

    lateinit var retrofit: Retrofit

    override fun onCreate() {
        super.onCreate()

    }

    private fun provideRetrofit() = Retrofit.Builder()
        .baseUrl("https://findwordapi.com/")
        .build()

}