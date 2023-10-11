package com.ilhomsoliev.pomodoroapp.shared.base_fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.ilhomsoliev.pomodoroapp.app.MainActivity
import com.ilhomsoliev.pomodoroapp.feature.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

abstract class AbsMainActivityFragment(@LayoutRes layout: Int) : Fragment(layout) {

    val baseViewModel: BaseViewModel by activityViewModel()

    val mainActivity: MainActivity
        get() = activity as MainActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.STARTED)*/
    }

}