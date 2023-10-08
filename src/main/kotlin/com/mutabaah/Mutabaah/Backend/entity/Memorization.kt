package com.mutabaah.Mutabaah.Backend.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "memorizations")
data class Memorization(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID?,
    val memorizationType: MemorizationType?,
    val juz: String?,
    val page: String?,
    val memorizationValue: String?,
    val recitationValue: String?,
    val category: String?,
    @Temporal(TemporalType.TIMESTAMP)
    val createdAt: LocalDateTime?,
    @Temporal(TemporalType.TIMESTAMP)
    val updatedAt: LocalDateTime?,

    @ManyToMany(mappedBy = "memorizations")
    val students: MutableList<Student> = mutableListOf()
    ) {
}

enum class MemorizationType {
    ZIYADAH,
    MUROJAAH
}