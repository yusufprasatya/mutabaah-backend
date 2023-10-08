package com.mutabaah.Mutabaah.Backend.controller

import com.mutabaah.Mutabaah.Backend.dto.ResponseDto
import com.mutabaah.Mutabaah.Backend.dto.UserDto
import com.mutabaah.Mutabaah.Backend.dto.toEntity
import com.mutabaah.Mutabaah.Backend.entity.User
import com.mutabaah.Mutabaah.Backend.service.UserService
import com.mutabaah.Mutabaah.Backend.util.DtoUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/user")
class UserController(val userService: UserService){

    @GetMapping
    fun getAllUsers(): ResponseEntity<out ResponseDto<out List<User>?>> {
        try {
            val response = DtoUtil.responseDtoSuccess(userService.findAllUser())
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: UUID): ResponseEntity<out ResponseDto<out User?>> {
        try {
            val response = DtoUtil.responseDtoSuccess(userService.findUserById(userId = userId))
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping
    fun saveUser(@RequestBody payload: UserDto): ResponseEntity<out ResponseDto<out User?>> {
        try {
            print(payload)
            val response = DtoUtil.responseDtoSuccess(userService.saveUser(payload.toEntity()))
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: UUID): ResponseEntity<out ResponseDto<out Boolean?>> {
        try {
            val response = DtoUtil.responseDtoSuccess(userService.deleteUser(id))
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }
}