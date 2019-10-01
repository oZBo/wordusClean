package com.braincollaboration.wordus.application

import android.app.Application
import com.braincollaboration.wordus.R
import com.braincollaboration.wordus.room.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class App : Application(), AppBridge {

    override val retrofit: Retrofit by lazy { provideRetrofit() }

    private val appModule = module {

        // single instance of HelloRepository
//        single<HelloRepository> { HelloRepositoryImpl() }

        // Simple Presenter Factory
//        factory { MySimplePresenter(get()) }
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
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.font_regular))
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }

    private fun initDatabase() {
        AppDatabase.initAppDataBase(this)
    }

    private fun provideRetrofit() = Retrofit.Builder()
        .baseUrl("https://findwordapi.com/")
        .build()

}