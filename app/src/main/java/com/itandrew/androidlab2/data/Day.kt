package com.itandrew.androidlab2.data

import java.time.DayOfWeek
import java.time.LocalDate

data class Day(
    val dayName: DayOfWeek,
    val date: LocalDate,
    val lessons: List<Lesson>
)