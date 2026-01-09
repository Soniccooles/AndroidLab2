package com.itandrew.androidlab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.itandrew.androidlab2.databinding.FragmentMainBinding
import dev.androidbroadcast.vbpd.viewBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            replaceFragment(TodayFragment())
            binding.bottomNavView.selectedItemId = R.id.item_today
        }

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_today -> {
                    replaceFragment(TodayFragment())
                    true // Возвращаем true, чтобы отметить пункт как выбранный
                }
                R.id.item_week -> {
                    replaceFragment(WeekFragment())
                    true
                }
                else -> false // Для других пунктов, если они появятся
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_layout, fragment)
            .commit()
    }
}