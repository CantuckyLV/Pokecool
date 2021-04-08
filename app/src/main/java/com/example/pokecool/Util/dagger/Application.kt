package com.example.pokecool.Util.dagger

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class Application : DaggerApplication()  {

    override fun onCreate() {
        super.onCreate()
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().build()
    }
}