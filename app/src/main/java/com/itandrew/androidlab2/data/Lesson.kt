package com.itandrew.androidlab2.data

data class Lesson(
    val id: Int,
    val startTime: String,
    val endTime: String,
    val subject: String,
    val teacher: String,
    val room: String
)