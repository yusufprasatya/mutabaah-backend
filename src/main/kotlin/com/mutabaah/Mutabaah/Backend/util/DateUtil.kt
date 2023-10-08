package com.mutabaah.Mutabaah.Backend.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateUtil {
    fun formatDate(date: LocalDate): String {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return date.format(formatter)
    }
}