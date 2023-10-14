package com.ilhomsoliev.pomodoroapp.app

import android.os.Bundle
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.shared.base.AbsBaseActivity
import com.ilhomsoliev.pomodoroapp.core.extentions.findNavController
import com.ilhomsoliev.pomodoroapp.core.util.AppRater

class MainActivity : AbsBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppRater.appLaunched(this)
        setupNavigationController()
    }

    private fun setupNavigationController() {
        val navController = findNavController(R.id.fragment_container)
        val navInflater = navController.navInflater
        val navGraph = navInflater.inflate(R.navigation.main_graph)
        navGraph.setStartDestination(R.id.action_timer)
        navController.graph = navGraph
    }

}