package com.braincollaboration.wordus.ui.screens.base.activity

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity(@LayoutRes layoutId: Int) : AppCompatActivity(layoutId), CoroutineScope {

    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
    }

    abstract fun initViews()

    override fun onDestroy() {
        super.onDestroy()
        job.cancelChildren()
    }

}