package com.ilhomsoliev.pomodoroapp.app

import android.app.Application
import cat.ereza.customactivityoncrash.config.CaocConfig
import com.ilhomsoliev.pomodoroapp.feature.error_handler.ErrorActivity
import com.ilhomsoliev.pomodoroapp.billing.BillingManager
import com.ilhomsoliev.pomodoroapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PomodoroApplication : Application() {

    lateinit var billingManager: BillingManager

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@PomodoroApplication)
            modules(appModules)
        }
        billingManager = BillingManager(this)

        // setting Error activity
        CaocConfig.Builder.create().errorActivity(ErrorActivity::class.java)
            .restartActivity(MainActivity::class.java).apply()

    }

    override fun onTerminate() {
        super.onTerminate()
        billingManager.release()
//         wallpaperAccentManager.release()
    }


    companion object {
        private var instance: PomodoroApplication? = null
        fun getContext(): PomodoroApplication {
            return instance!!
        }

        fun isProVersion(): Boolean {
            return /*BuildConfig.DEBUG ||*/ instance?.billingManager!!.isProVersion
        }
    }
}