package com.itandrew.androidlab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.itandrew.androidlab2.adapter.LessonAdapter
import com.itandrew.androidlab2.data.DataSource
import com.itandrew.androidlab2.data.Day
import com.itandrew.androidlab2.databinding.FragmentTodayBinding
import dev.androidbroadcast.vbpd.viewBinding
import java.time.LocalDate

class TodayFragment : Fragment(R.layout.fragment_today) {
    val binding: FragmentTodayBinding by viewBinding(FragmentTodayBinding::bind)
    private lateinit var lessonAdapter: LessonAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val today = LocalDate.now()
        val currentDayOfWeek = today.dayOfWeek
        val currentWeekType = DataSource.getCurrentWeekType()

        val monday = today.minusDays(currentDayOfWeek.value.toLong() - 1)
        val todaySchedule = DataSource.generateWeekSchedule(monday, currentWeekType).find { it.date == today }

        if (todaySchedule != null && todaySchedule.lessons.isNotEmpty()) {
            binding.noLessonsToday.visibility = View.GONE
            binding.recyclerToday.visibility = View.VISIBLE
            lessonAdapter = LessonAdapter(todaySchedule.lessons)
            binding.recyclerToday.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = lessonAdapter
            }
        } else {
            binding.noLessonsToday.visibility = View.VISIBLE
            binding.recyclerToday.visibility = View.GONE
        }
    }
}