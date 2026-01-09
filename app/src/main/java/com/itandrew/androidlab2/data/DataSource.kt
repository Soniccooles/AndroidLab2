package com.itandrew.androidlab2.data

import android.icu.util.Calendar
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

object DataSource {

    fun createMockSchedule(): List<Week> {
        val today = LocalDate.now()

        // --- Моковые данные для Четной Недели ---
        val evenWeekDays = mutableListOf<Day>()
        // Добавляем дни текущей недели, начиная с понедельника
        for (i in 0 until 7) {
            val date = today.minusDays(today.dayOfWeek.value.toLong() - 1).plusDays(i.toLong())
            val dayOfWeek = DayOfWeek.of((i % 7) + 1) // Понедельник = 1

            val lessonsForDay = when (dayOfWeek) {
                DayOfWeek.MONDAY -> listOf(
                    Lesson(1, LocalTime.of(16, 40), LocalTime.of(18, 10), "Физра", "Гизатулина А.А.", "дистант"),
                    Lesson(2, LocalTime.of(18, 20), LocalTime.of(19, 50), "Тестирование ПО", "Булавин Р.С.", "дистант"),
                )

                DayOfWeek.TUESDAY -> listOf(
                    Lesson(3, LocalTime.of(18, 20), LocalTime.of(19, 50), "Управление ИТ-проектами", "Воробьёв В.И.", "А-21"),
                    Lesson(4, LocalTime.of(18, 20), LocalTime.of(19, 50), "Управление ИТ-проектами", "Воробьёв В.И.", "А-21")
                )

                DayOfWeek.THURSDAY -> listOf(
                    Lesson(5, LocalTime.of(19, 0), LocalTime.of(20, 30), "Разработка интернет-приложений", "Павличенков Е.А.", "Дистант"),
                    Lesson(6, LocalTime.of(20, 30), LocalTime.of(22, 0), "Разработка интернет-приложений", "Павличенков Е.А.", "Дистант")
                )

                DayOfWeek.FRIDAY -> listOf(
                    Lesson(7, LocalTime.of(13, 15), LocalTime.of(14, 45), "Экономика ПрИ", "Ткач Е.С.", "2 корпус, 226"),
                    Lesson(8, LocalTime.of(15, 0), LocalTime.of(16, 30), "Экономика ПрИ", "Ткач Е.С.", "2 корпус, 226")
                )

                DayOfWeek.SATURDAY -> listOf(
                    Lesson(9, LocalTime.of(8, 0), LocalTime.of(9, 30), "Анализ данных", "Мирасов В.Ф.", "Дистант"),
                    Lesson(10, LocalTime.of(9, 40), LocalTime.of(11, 10), "Анализ данных", "Мирасов В.Ф.", "Дистант"),
                    Lesson(11, LocalTime.of(13, 15), LocalTime.of(14, 45), "Базы и хранилища данных", "Барабанщиков И.В.", "326"),
                    Lesson(12, LocalTime.of(15, 0), LocalTime.of(16, 30), "Технологии прикладного программирования", "Веригин Н.В.", "132"),
                    Lesson(13, LocalTime.of(16, 40), LocalTime.of(18, 10), "Технологии прикладного программирования", "Веригин Н.В.", "132")
                )

                else -> emptyList() // ср и вс
            }
            evenWeekDays.add(Day(dayOfWeek, date, lessonsForDay))
        }

        // --- Моковые данные для Нечетной Недели ---
        val oddWeekDays = mutableListOf<Day>()
        // Добавляем дни следующей недели, начиная с понедельника
        for (i in 0 until 7) {
            val date = today.plusWeeks(1).minusDays(today.dayOfWeek.value.toLong() - 1).plusDays(i.toLong())
            val dayOfWeek = DayOfWeek.of((i % 7) + 1)

            val lessonsForDay = when (dayOfWeek) {
                DayOfWeek.MONDAY -> listOf(
                    Lesson(14, LocalTime.of(16, 40), LocalTime.of(18, 10), "Физра", "Гизатулина А.А.", "4 корпус"),
                    Lesson(15, LocalTime.of(18, 20), LocalTime.of(19, 50), "Базы и хранилища данных", "Барабанщиков И.В.", "А-21"),
                    Lesson(16, LocalTime.of(19, 55), LocalTime.of(21, 25), "Базы и хранилища данных", "Барабанщиков И.В.", "А-21")
                )
                DayOfWeek.TUESDAY -> listOf(
                    Lesson(17, LocalTime.of(18, 20), LocalTime.of(19, 50), "Управление ИТ-проектами", "Воробьёв В.И.", "А-21."),
                    Lesson(18, LocalTime.of(19, 55), LocalTime.of(21, 25), "Управление ИТ-проектами", "Воробьёв В.И.", "А-21.")
                )
                DayOfWeek.WEDNESDAY -> listOf(
                    Lesson(19, LocalTime.of(18, 20), LocalTime.of(19, 50), "Базы и хранилища данных", "Барабанщиков И.В.", "326"),
                    Lesson(20, LocalTime.of(19, 55), LocalTime.of(21, 25), "Базы и хранилища данных", "Барабанщиков И.В.", "326"),
                )

                DayOfWeek.THURSDAY -> listOf(
                    Lesson(21, LocalTime.of(19, 0), LocalTime.of(20, 30), "Разработка интернет-приложений", "Павличенков Е.А.", "Дистант"),
                    Lesson(22, LocalTime.of(20, 30), LocalTime.of(22, 0), "Разработка интернет-приложений", "Павличенков Е.А.", "Дистант")
                )

                DayOfWeek.SATURDAY -> listOf(
                    Lesson(23, LocalTime.of(8, 0), LocalTime.of(9, 30), "Анализ данных", "Мирасов В.Ф.", "Дистант"),
                    Lesson(24, LocalTime.of(11, 20), LocalTime.of(12, 50), "Тестирование ПО", "Булавин Р.С.", "132"),
                    Lesson(24, LocalTime.of(13, 15), LocalTime.of(14, 45), "Тестирование ПО", "Булавин Р.С.", "132"),
                    Lesson(25, LocalTime.of(15, 0), LocalTime.of(16, 30), "Технологии прикладного программирования", "Веригин Н.В.", "132"),
                    Lesson(26, LocalTime.of(16, 40), LocalTime.of(18, 10), "Технологии прикладного программирования", "Веригин Н.В.", "132")
                )

                else -> emptyList() // пт и вс
            }
            oddWeekDays.add(Day(dayOfWeek, date, lessonsForDay))
        }

        return listOf(
            Week(WeekType.EVEN, evenWeekDays),
            Week(WeekType.ODD, oddWeekDays)
        )
    }

    fun getCurrentWeekType(): WeekType {
        val calendar = Calendar.getInstance()
        val weekNumber = calendar.get(Calendar.WEEK_OF_YEAR)
        return if (weekNumber % 2 == 0) WeekType.EVEN else WeekType.ODD
    }
}