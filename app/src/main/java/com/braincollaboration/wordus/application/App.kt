package com.braincollaboration.wordus.application

import android.app.Application
import com.braincollaboration.wordus.R
import com.braincollaboration.wordus.feature.home.WordsViewModel
import com.braincollaboration.wordus.feature.home.api.WordRepository
import com.braincollaboration.wordus.feature.home.api.WordService
import com.braincollaboration.wordus.feature.home.interactor.GetWordsUseCase
import com.braincollaboration.wordus.room.AppDatabase
import io.github.inflationx.calligraphy3.CalligraphyConfig
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit

class App : Application(), AppBridge {

    override val retrofit: Retrofit by lazy { provideRetrofit() }

    private val appModule = module {

        single { WordService(retrofit) }
        single<WordRepository> { WordRepository.Network(get()) }
        single { GetWordsUseCase(get()) }

        viewModel { WordsViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init() {
        initDatabase()
        initCustomFont()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            // Android context
            androidContext(this@App)
            // modules
            modules(appModule)
        }
    }

    private fun initCustomFont() {
            CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.font_regular))
                .setFontAttrId(R.attr.fontPath)
                .build()
    }

    private fun initDatabase() {
        AppDatabase.initAppDataBase(this)
    }

    private fun provideRetrofit() = Retrofit.Builder()
        .baseUrl("https://findwordapi.com/")
        .build()

}