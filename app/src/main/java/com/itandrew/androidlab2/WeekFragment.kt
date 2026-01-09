package com.itandrew.androidlab2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.itandrew.androidlab2.adapter.WeekDayAdapter
import com.itandrew.androidlab2.data.DataSource
import com.itandrew.androidlab2.data.WeekType
import com.itandrew.androidlab2.databinding.FragmentWeekBinding
import dev.androidbroadcast.vbpd.viewBinding
import java.time.LocalDate

class WeekFragment : Fragment(R.layout.fragment_week) {
    val binding: FragmentWeekBinding by viewBinding(FragmentWeekBinding::bind)
    private lateinit var weekDayAdapter: WeekDayAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val today = LocalDate.now()
        val currentDayOfWeek = today.dayOfWeek
        val currentWeekType = DataSource.getCurrentWeekType()
        val monday = today.minusDays(currentDayOfWeek.value.toLong() - 1)
        val currentWeekSchedule = DataSource.generateWeekSchedule(monday, currentWeekType)
        if (currentWeekSchedule.isNotEmpty()) {
            binding.weekDayNoLessons.visibility = View.GONE
            binding.recyclerWeek.visibility = View.VISIBLE

            binding.weekType.text = when (currentWeekType) {
                WeekType.EVEN -> "Четная неделя"
                WeekType.ODD -> "Нечетная неделя"
            }

            weekDayAdapter = WeekDayAdapter(currentWeekSchedule)
            binding.recyclerWeek.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = weekDayAdapter
            }
        } else {
            binding.weekDayNoLessons.visibility = View.VISIBLE
            binding.recyclerWeek.visibility = View.GONE
        }
    }
}