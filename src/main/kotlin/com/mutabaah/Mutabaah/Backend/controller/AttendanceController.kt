package com.mutabaah.Mutabaah.Backend.controller

import com.mutabaah.Mutabaah.Backend.dto.*
import com.mutabaah.Mutabaah.Backend.entity.Attendance
import com.mutabaah.Mutabaah.Backend.service.AttendanceService
import com.mutabaah.Mutabaah.Backend.util.DtoUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/attendance")
class AttendanceController(val attendanceService: AttendanceService){

    @GetMapping
    fun getAllAttendances(): ResponseEntity<out ResponseDto<out List<Attendance>?>> {
        try {
            val response = DtoUtil.responseDtoSuccess(attendanceService.findAllAttendances())
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            print("error disini")
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping
    fun saveAttendance(@RequestBody payload: AttendanceDto ): ResponseEntity<out ResponseDto<out Boolean?>> {
        try {
            print(payload)
            val response = DtoUtil.responseDtoSuccess(attendanceService.saveAttendance(payload))
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }
}