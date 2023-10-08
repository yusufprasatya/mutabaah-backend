package com.mutabaah.Mutabaah.Backend.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "schedules")
data class Schedule (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID?,
    val name: String?,
    val startTime: String?,
    val endTime: String?,
    @Temporal(TemporalType.TIMESTAMP)
    val createdAt: LocalDateTime?,
    @Temporal(TemporalType.TIMESTAMP)
    val updatedAt: LocalDateTime?,

    // relationship
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User?,

    @OneToMany(mappedBy = "schedule", cascade = [CascadeType.ALL])
    val students: List<Student> = mutableListOf()

) {
}