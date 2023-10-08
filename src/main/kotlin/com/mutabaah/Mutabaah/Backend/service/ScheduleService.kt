package com.mutabaah.Mutabaah.Backend.service

import com.mutabaah.Mutabaah.Backend.entity.Schedule
import com.mutabaah.Mutabaah.Backend.entity.User
import com.mutabaah.Mutabaah.Backend.exception.UserNotFoundException
import com.mutabaah.Mutabaah.Backend.repository.ScheduleRepository
import com.mutabaah.Mutabaah.Backend.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ScheduleService(val scheduleRepository: ScheduleRepository) {
    fun findAllSchedule(): List<Schedule> = scheduleRepository.findAll()

    fun findScheduleById(id: UUID): Schedule = scheduleRepository.findById(id).orElseThrow{
        UserNotFoundException("Schedule not found")
    }

    fun saveSchedule(schedule: Schedule): Schedule = scheduleRepository.save(schedule)

    fun deleteSchedule(id: UUID): Boolean {
        return if(scheduleRepository.existsById(id)) {
            scheduleRepository.deleteById(id)
            return true
        } else throw UserNotFoundException("Schedule not found")
    }
}