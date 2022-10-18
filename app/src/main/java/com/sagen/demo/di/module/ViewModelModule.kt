package com.sagen.demo.di.module

import androidx.lifecycle.ViewModel
import com.sagen.demo.ui.main.MainViewModel
import com.sagen.demo.ui.main.StaticsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    //@StringKey("mainViewModel")
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    //@StringKey("staticsViewModel")
    @ClassKey(StaticsViewModel::class)
    @IntoMap
    abstract fun bindStaticsViewModel(staticsViewModel: StaticsViewModel): ViewModel
}