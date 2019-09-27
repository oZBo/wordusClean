package com.braincollaboration.wordus.application

import android.app.Application
import com.braincollaboration.wordus.room.AppDatabase
import retrofit2.Retrofit


class App : Application(), AppBridge {

    override val retrofit: Retrofit by lazy { provideRetrofit() }

    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init() {
        initDatabase()
    }

    private fun initDatabase() {
        AppDatabase.initAppDataBase(this)
    }

    private fun provideRetrofit() = Retrofit.Builder()
            .baseUrl("https://findwordapi.com/")
            .build()

}