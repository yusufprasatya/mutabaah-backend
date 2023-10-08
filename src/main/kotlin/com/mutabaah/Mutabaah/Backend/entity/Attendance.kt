package com.mutabaah.Mutabaah.Backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.NoArgsConstructor
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
    @JoinColumn(name = "student_id")
    @JsonIgnore
    val student: Student?
) {
}