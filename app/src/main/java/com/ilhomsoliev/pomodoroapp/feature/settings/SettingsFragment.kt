package com.ilhomsoliev.pomodoroapp.feature.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.core.extentions.printToLog
import com.ilhomsoliev.pomodoroapp.databinding.FragmentSettingsBinding
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.SettingsScreen
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.viewmodel.SettingsViewModel
import com.ilhomsoliev.pomodoroapp.shared.base_fragment.AbsMainActivityFragment
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment : AbsMainActivityFragment(R.layout.fragment_settings),
    SharedPreferences.OnSharedPreferenceChangeListener {

    private var _binding: SettingsBinding? = null
    private val binding get() = _binding!!

    private val contextKoin by this.getKoin().inject<Context>()

    private val vm: SettingsViewModel by viewModel() // = koinViewModel<SettingsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val settingsBinding = FragmentSettingsBinding.bind(view)
        _binding = SettingsBinding(settingsBinding)
        /*mainActivity.setSupportActionBar(binding.toolbar)
        setupToolbarTitle()*/
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    SettingsScreen(vm = vm, onBack = {
                        findNavController().navigateUp()
                    })
                }
            }
        }
    }

    override fun onSharedPreferenceChanged(
        sharedPreferences: SharedPreferences?,
        key: String?
    ) {
        key.printToLog("KEEEEY")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)

    }

    @Subscribe
    fun onEventMainThread(o: Any?) {

    }

}