package com.mutabaah.Mutabaah.Backend.dto

import com.mutabaah.Mutabaah.Backend.entity.User
import com.mutabaah.Mutabaah.Backend.entity.UserRole
import java.time.LocalDateTime
data class UserDto(
    val name: String?,
    val username: String?,
    var password: String?,
    val role: UserRole?
){
}

fun UserDto.toEntity() = User(
    id = null,
    name = name,
    username = username,
    password = password,
    role = UserRole.USER,
    createdAt = LocalDateTime.now(),
    updatedAt = null,
)
