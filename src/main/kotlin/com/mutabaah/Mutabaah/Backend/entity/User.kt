package com.mutabaah.Mutabaah.Backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID?,
    val name: String?,
    val username: String?,
    var password: String?,
    @Enumerated(EnumType.STRING)
    val role:  UserRole?,
    @Temporal(TemporalType.TIMESTAMP)
    val createdAt: LocalDateTime?,
    @Temporal(TemporalType.TIMESTAMP)
    val updatedAt: LocalDateTime?,

    // relationship
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
    val schedules: List<Schedule> = mutableListOf(),
) {
}

enum class UserRole {
    USER,
    ADMIN
}