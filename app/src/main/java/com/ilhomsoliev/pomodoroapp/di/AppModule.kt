package com.ilhomsoliev.pomodoroapp.di

import com.ilhomsoliev.pomodoroapp.feature.BaseViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val viewModules = module {
    viewModel {
        BaseViewModel()
    }
}

private val dataModule = module {

}

private val mainModule = module {
    single {
        androidContext().contentResolver
    }
    /*single {
        RetroWebServer(get())
    }*/
}
val appModules = listOf(mainModule, dataModule, viewModules)