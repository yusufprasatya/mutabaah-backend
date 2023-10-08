package com.mutabaah.Mutabaah.Backend.dto

import com.mutabaah.Mutabaah.Backend.entity.Gender
import com.mutabaah.Mutabaah.Backend.entity.Student
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.util.*

data class StudentDto(
    val fullName: String?,
    val gender: String?,
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    val dob: Date?,
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    val startProgram: Date?,
){
    fun getGender(gender: String?): Gender {
        if (gender.equals("l")){
            return Gender.MALE
        }
        return Gender.FEMALE
    }
}

fun StudentDto.toEntity() = Student(
    id = null,
    fullName = fullName,
    gender = getGender(gender),
    dob = dob,
    startProgram = startProgram,
    schedule = null,
    createdAt = LocalDateTime.now(),
    updatedAt = null
)
