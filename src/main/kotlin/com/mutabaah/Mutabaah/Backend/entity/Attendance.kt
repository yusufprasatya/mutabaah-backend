package com.mutabaah.Mutabaah.Backend.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "attendances")
data class Attendance (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID?,
    val isPresence: Boolean?,
    val attendanceDate: Date?,
    @Temporal(TemporalType.TIMESTAMP)
    val createdAt: LocalDateTime?,
    @Temporal(TemporalType.TIMESTAMP)
    val updatedAt: LocalDateTime?,

    // relationship
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User?
) {
}