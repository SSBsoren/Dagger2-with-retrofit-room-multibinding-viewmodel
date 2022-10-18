package com.sagen.demo

import android.app.Application
import com.sagen.demo.di.component.ApplicationComponent
import com.sagen.demo.di.component.DaggerApplicationComponent

class DemoApplication :Application() {
    lateinit var appComponent:ApplicationComponent
    override fun onCreate() {
        super.onCreate()
       appComponent = DaggerApplicationComponent.factory().create(this)
    }
}