package com.clb.lx.app

import android.app.Application

class MyApp: Application() {

    companion object {
        private lateinit var appContext: MyApp

        @JvmStatic
        fun getAppContext(): MyApp {
            return appContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        appContext = this
    }
}