package com.lampro.myaccuweather

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    companion object {
        lateinit var context: Context
        fun getAppContext(): Context {
            return context
        }
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}