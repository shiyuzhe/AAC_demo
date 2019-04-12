package com.syz.aac_demo

import android.app.Application

class App:Application() {
    companion object {
        private lateinit var instance:Application
        fun getIns() = instance
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}