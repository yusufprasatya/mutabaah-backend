package com.mutabaah.Mutabaah.Backend.controller

import com.mutabaah.Mutabaah.Backend.dto.*
import com.mutabaah.Mutabaah.Backend.entity.Schedule
import com.mutabaah.Mutabaah.Backend.entity.Student
import com.mutabaah.Mutabaah.Backend.entity.User
import com.mutabaah.Mutabaah.Backend.service.ScheduleService
import com.mutabaah.Mutabaah.Backend.service.StudentService
import com.mutabaah.Mutabaah.Backend.service.UserService
import com.mutabaah.Mutabaah.Backend.util.DtoUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/schedule")
class ScheduleController(val scheduleService: ScheduleService){

    @GetMapping
    fun getAllSchedules(): ResponseEntity<out ResponseDto<out List<Schedule>?>> {
        try {
            val response = DtoUtil.responseDtoSuccess(scheduleService.findAllSchedule())
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("/{id}")
    fun getScheduleById(@PathVariable id: UUID): ResponseEntity<out ResponseDto<out Schedule?>> {
        try {
            val response = DtoUtil.responseDtoSuccess(scheduleService.findScheduleById(id = id))
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping
    fun saveUser(@RequestBody payload: ScheduleDto): ResponseEntity<out ResponseDto<out Schedule?>> {
        try {
            print(payload)
            val response = DtoUtil.responseDtoSuccess(scheduleService.saveSchedule(payload.toEntity()))
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteScheduler(@PathVariable id: UUID): ResponseEntity<out ResponseDto<out Boolean?>> {
        try {
            val response = DtoUtil.responseDtoSuccess(scheduleService.deleteSchedule(id))
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }
}