package com.mutabaah.Mutabaah.Backend.service

import com.mutabaah.Mutabaah.Backend.dto.AttendanceDto
import com.mutabaah.Mutabaah.Backend.entity.Attendance
import com.mutabaah.Mutabaah.Backend.exception.UserNotFoundException
import com.mutabaah.Mutabaah.Backend.repository.AttendanceRepository
import com.mutabaah.Mutabaah.Backend.repository.StudentRepository
import com.mutabaah.Mutabaah.Backend.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*
import kotlin.math.truncate

@Service
class AttendanceService(val attendanceRepository: AttendanceRepository, val studentRepository: StudentRepository) {
    fun findAllAttendances(): List<Attendance> = attendanceRepository.findAll()

    fun findAttendanceById(id: UUID): Attendance = attendanceRepository.findById(id).orElseThrow{
        UserNotFoundException("Attendance not found")
    }

    fun saveAttendance(payload: AttendanceDto): Boolean {
        val studentOptional = studentRepository.findById(payload.student)
        if (!studentOptional.isPresent) {
            throw UserNotFoundException("Student not found!")
        }

        val attendance = Attendance(
            id = null,
            isPresence = payload.isPresence,
            attendanceDate = payload.attendanceDate,
            createdAt = LocalDateTime.now(),
            updatedAt = null,
            student = studentOptional.get()
        )

        val savedAttendance = attendanceRepository.save(attendance)

        return savedAttendance != null
    }

    fun deleteAttendance(id: UUID): Boolean {
        return if(attendanceRepository.existsById(id)) {
            attendanceRepository.deleteById(id)
            return true
        } else throw UserNotFoundException("Attendance not found")
    }
}