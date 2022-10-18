package com.sagen.demo.di.component

import android.content.Context
import androidx.lifecycle.ViewModel
import com.sagen.demo.di.module.DatabaseModule
import com.sagen.demo.ui.main.MainActivity
import com.sagen.demo.di.module.NetworkModule
import com.sagen.demo.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,DatabaseModule::class,ViewModelModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

   // fun getStringKeyMap():Map<String,ViewModel>
    fun getClassKeyMap():Map<Class<*>,ViewModel>
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):ApplicationComponent

    }
}