package com.ilhomsoliev.pomodoroapp.feature.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.databinding.FragmentSettingsBinding
import com.ilhomsoliev.pomodoroapp.shared.base_fragment.AbsMainActivityFragment
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class SettingsFragment : AbsMainActivityFragment(R.layout.fragment_settings),
    SharedPreferences.OnSharedPreferenceChangeListener {

    private var _binding: SettingsBinding? = null
    private val binding get() = _binding!!

    private val contextKoin by this.getKoin().inject<Context>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val settingsBinding = FragmentSettingsBinding.bind(view)
        _binding = SettingsBinding(settingsBinding)

    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }

    @Subscribe
    fun onEventMainThread(o: Any?) {

    }

}