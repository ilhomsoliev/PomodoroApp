package com.ilhomsoliev.pomodoroapp.feature.settings.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.withStyledAttributes
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.databinding.SettingsPreferenceItemViewBinding

class SettingsPreferenceItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = -1,
    defStyleRes: Int = -1
) :
    FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var _binding: SettingsPrefBinding? = null
    val binding get() = _binding!!

    init {
        _binding = SettingsPrefBinding(
            SettingsPreferenceItemViewBinding.inflate(
                LayoutInflater.from(context), this, true
            )
        )

        context.withStyledAttributes(attrs, R.styleable.SettingsPrefItem, 0, 0) {
            binding.title.text = getText(R.styleable.SettingsPrefItem_prefTitle)

            val description = getText(R.styleable.SettingsPrefItem_prefDescription)
            if (description.isEmpty()) {
                binding.description.visibility = View.GONE
            } else
                binding.description.text = description

            binding.icon.setImageResource(
                getResourceId(
                    R.styleable.SettingsPrefItem_prefIcon,
                    R.drawable.ic_about
                )
            )
            val hasToggle = getBoolean(R.styleable.SettingsPrefItem_prefHasToggle, false)
            if (!hasToggle) {
                binding.toggle.visibility = View.GONE
            }
        }
    }

}

class SettingsPrefBinding(
    binding: SettingsPreferenceItemViewBinding
) {
    val root = binding.root
    val title = binding.title
    val description = binding.description
    val icon = binding.icon
    val toggle = binding.toggle
}