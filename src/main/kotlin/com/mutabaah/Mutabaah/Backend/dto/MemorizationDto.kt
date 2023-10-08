package com.mutabaah.Mutabaah.Backend.dto

import com.mutabaah.Mutabaah.Backend.entity.Memorization
import java.time.LocalDateTime
import java.util.UUID

data class MemorizationDto(
    val student: UUID,
    val memorizationType: String?,
    val juz: String?,
    val page: String?,
    val memorizationValue: String?,
    val recitationValue: String?,
    val category: String?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
){
}

fun MemorizationDto.toEntity() = Memorization(
    id = null,
    memorizationType = null,
    juz = juz,
    page = page,
    memorizationValue = memorizationValue,
    recitationValue = recitationValue,
    category = category,
    createdAt = LocalDateTime.now(),
    updatedAt = null,
    student = null
)
