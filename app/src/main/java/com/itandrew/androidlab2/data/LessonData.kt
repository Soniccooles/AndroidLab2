package com.itandrew.androidlab2.data

import java.time.LocalDateTime

data class LessonData(
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val subject: String,
    val teacher: String,
    val room: String
)