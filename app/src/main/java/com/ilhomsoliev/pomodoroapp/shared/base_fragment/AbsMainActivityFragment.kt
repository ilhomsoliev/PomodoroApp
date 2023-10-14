package com.ilhomsoliev.pomodoroapp.shared.base_fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.ilhomsoliev.pomodoroapp.app.MainActivity
import com.ilhomsoliev.pomodoroapp.feature.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.component.KoinComponent

open class AbsMainActivityFragment(@LayoutRes layout: Int) : Fragment(layout), KoinComponent {

    val baseViewModel: BaseViewModel by activityViewModel()

    val mainActivity: MainActivity
        get() = activity as MainActivity
    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.STARTED)*/
    }

}