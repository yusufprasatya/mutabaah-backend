package com.mutabaah.Mutabaah.Backend.dto

import org.springframework.format.annotation.DateTimeFormat
import java.util.*

data class AttendanceDto(
    val isPresence: Boolean?,
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    val attendanceDate: Date?,
    val student: UUID
){
}
