package com.mutabaah.Mutabaah.Backend.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "students")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID?,
    val fullName: String?,
    val gender: Gender?,
    val dob: Date?,
    val startProgram: Date?,
    @Temporal(TemporalType.TIMESTAMP)
    val createdAt: LocalDateTime?,
    @Temporal(TemporalType.TIMESTAMP)
    val updatedAt: LocalDateTime?,

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    val schedule: Schedule?,

    @OneToMany(mappedBy = "student", cascade = [CascadeType.ALL], orphanRemoval = true)
    val attendances: List<Attendance> = mutableListOf(),

    @OneToMany(mappedBy = "student", cascade = [CascadeType.ALL], orphanRemoval = true)
    val memorizations: List<Memorization> = mutableListOf()
) {
}

enum class Gender {
    MALE,
    FEMALE
}