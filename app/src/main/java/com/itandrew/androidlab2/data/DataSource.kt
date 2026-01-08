package com.itandrew.androidlab2.data

import android.icu.util.Calendar

object DataSource {
    fun getCurrentWeekType(): WeekType {
        val calendar = Calendar.getInstance()
        val weekNumber = calendar.get(Calendar.WEEK_OF_YEAR)
        return if (weekNumber % 2 == 0) WeekType.EVEN else WeekType.ODD
    }
}