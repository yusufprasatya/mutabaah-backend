package com.mutabaah.Mutabaah.Backend.controller

import com.mutabaah.Mutabaah.Backend.dto.MemorizationDto
import com.mutabaah.Mutabaah.Backend.dto.ResponseDto
import com.mutabaah.Mutabaah.Backend.entity.Memorization
import com.mutabaah.Mutabaah.Backend.service.MemorizationService
import com.mutabaah.Mutabaah.Backend.util.DtoUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/memorization")
class MemorizationController(val memorizationService: MemorizationService) {

    @PostMapping
    fun saveMemorization(@RequestBody payload: MemorizationDto): ResponseEntity<out ResponseDto<out Memorization?>> {
        try {
            print(payload)
            val response = DtoUtil.responseDtoSuccess(memorizationService.saveMemorization(payload))
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping
    fun getAllMemorization(): ResponseEntity<out ResponseDto<out List<Memorization>?>> {
        try {
            val response = DtoUtil.responseDtoSuccess(memorizationService.findAllMemorizations())
            return ResponseEntity(response, HttpStatus.OK)
        } catch (e: Exception) {
            val response = DtoUtil.responseDtoFailed(null, e.message.orEmpty(), HttpStatus.BAD_REQUEST)
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }
    }
}