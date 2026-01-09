package com.itandrew.androidlab2.data

import java.time.LocalTime

data class Lesson(
    val id: Int,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val subject: String,
    val teacher: String,
    val room: String
)