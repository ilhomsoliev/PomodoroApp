package com.ilhomsoliev.pomodoroapp.di

import com.ilhomsoliev.pomodoroapp.core.PreferenceUtil
import com.ilhomsoliev.pomodoroapp.data.timer.CurrentSessionManager
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
    single {
        CurrentSessionManager(get(), PreferenceUtil)
    }
}

private val mainModule = module {
    single {
        androidContext().contentResolver
    }
}
val appModules = listOf(mainModule, dataModule, viewModules)