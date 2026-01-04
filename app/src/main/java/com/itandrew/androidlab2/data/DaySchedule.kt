package com.itandrew.androidlab2.data

data class DaySchedule(
    val id: Int,
    val dayName: String,
    val lessons: List<Lesson>
)