package com.itandrew.androidlab2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itandrew.androidlab2.data.Day
import com.itandrew.androidlab2.databinding.ItemDayBinding
import java.time.format.DateTimeFormatter
import java.util.Locale

class WeekDayAdapter(private val days: List<Day>) : RecyclerView.Adapter<WeekDayAdapter.DayViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeekDayAdapter.DayViewHolder {
        val binding = ItemDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeekDayAdapter.DayViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return days.size
    }

    class DayViewHolder(private val binding: ItemDayBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(day: Day) {
            val formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM", Locale("ru", "RU"))
            binding.dayHeader.text = day.date.format(formatter)

            if (day.lessons.isEmpty()) {
                binding.lessonsRecycler.visibility = View.GONE
                binding.noLessons.visibility = View.VISIBLE
            } else {
                binding.lessonsRecycler.visibility = View.VISIBLE
                binding.noLessons.visibility = View.GONE
                binding.lessonsRecycler.apply {
                    layoutManager = LinearLayoutManager(itemView.context)
                    adapter = LessonAdapter(day.lessons)
                    isNestedScrollingEnabled = false
                }
            }
        }
    }

}