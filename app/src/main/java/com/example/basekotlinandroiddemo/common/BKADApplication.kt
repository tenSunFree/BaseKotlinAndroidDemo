package com.example.basekotlinandroiddemo.common

import android.app.Application
import com.example.basekotlinandroiddemo.BuildConfig
import com.github.ajalt.timberkt.Timber
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BKADApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
