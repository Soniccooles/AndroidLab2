package com.itandrew.androidlab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.itandrew.androidlab2.databinding.FragmentTodayBinding
import dev.androidbroadcast.vbpd.viewBinding

class TodayFragment : Fragment() {
    val binding: FragmentTodayBinding by viewBinding(FragmentTodayBinding::bind)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}