package com.mutabaah.Mutabaah.Backend.dto

import com.mutabaah.Mutabaah.Backend.entity.Schedule
import java.time.LocalDateTime

data class ScheduleDto(
    val name: String?,
    val startTime: String?,
    val endTime: String?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
){
}

fun ScheduleDto.toEntity() = Schedule(
    id = null,
    name = name,
    startTime = startTime,
    endTime = endTime,
    createdAt = LocalDateTime.now(),
    updatedAt = null,
    user = null
)
