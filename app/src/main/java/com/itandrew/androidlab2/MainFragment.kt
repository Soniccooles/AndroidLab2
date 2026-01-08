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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        replaceFragment(TodayFragment())    
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_today -> replaceFragment(TodayFragment())
                R.id.item_week -> replaceFragment(WeekFragment())

                else -> {

                }
            }
            true
        }


        super.onViewCreated(view, savedInstanceState)
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_layout, fragment)
            .commit()
    }
}