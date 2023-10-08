package com.mutabaah.Mutabaah.Backend.controller

import com.mutabaah.Mutabaah.Backend.dto.ResponseDto
import com.mutabaah.Mutabaah.Backend.dto.StudentDto
import com.mutabaah.Mutabaah.Backend.dto.UserDto
import com.mutabaah.Mutabaah.Backend.dto.toEntity
import com.mutabaah.Mutabaah.Backend.entity.Student
import com.mutabaah.Mutabaah.Backend.entity.User
import com.mutabaah.Mutabaah.Backend.service.StudentService
import com.mutabaah.Mutabaah.Backend.service.UserService
import com.mutabaah.Mutabaah.Backend.util.DtoUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/student")
class StudentController(val studentService: StudentService){

    @GetMapping
    fun getAllStudents(): ResponseEntity<out ResponseDto<out List<Student>?>> {
        try {
            val response = DtoUtil.responseDtoSuccess(studentService.findAllStudents())
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: UUID): ResponseEntity<out ResponseDto<out Student?>> {
        try {
            val response = DtoUtil.responseDtoSuccess(studentService.findStudentById(id = id))
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping
    fun saveUser(@RequestBody payload: StudentDto): ResponseEntity<out ResponseDto<out Student?>> {
        try {
            print(payload)
            val response = DtoUtil.responseDtoSuccess(studentService.saveStudent(payload.toEntity()))
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: UUID): ResponseEntity<out ResponseDto<out Boolean?>> {
        try {
            val response = DtoUtil.responseDtoSuccess(studentService.deleteStudent(id))
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }
}