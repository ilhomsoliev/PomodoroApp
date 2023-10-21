package com.ilhomsoliev.pomodoroapp.feature.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.text.parseAsHtml
import androidx.navigation.fragment.findNavController
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.core.extentions.accentColor
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
        mainActivity.setSupportActionBar(binding.toolbar)
        setupToolbarTitle()
    }

    private fun setupToolbarTitle() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        val appName = "Settings"
        binding.toolbar.title = appName
        binding.timerDurationPref.root.setOnClickListener {
            Toast.makeText(this@SettingsFragment.contextKoin, "Hey", Toast.LENGTH_LONG).show()
        }

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