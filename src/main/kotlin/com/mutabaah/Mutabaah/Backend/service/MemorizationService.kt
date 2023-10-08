package com.mutabaah.Mutabaah.Backend.service

import com.mutabaah.Mutabaah.Backend.dto.MemorizationDto
import com.mutabaah.Mutabaah.Backend.entity.Memorization
import com.mutabaah.Mutabaah.Backend.entity.MemorizationType
import com.mutabaah.Mutabaah.Backend.exception.UserNotFoundException
import com.mutabaah.Mutabaah.Backend.repository.MemorizationRepository
import com.mutabaah.Mutabaah.Backend.repository.StudentRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class MemorizationService(val memorizationRepository: MemorizationRepository, val studentRepository: StudentRepository) {

    fun saveMemorization(payload: MemorizationDto): Memorization {
        val studentOptional = studentRepository.findById(payload.student)
        if (!studentOptional.isPresent) {
            throw UserNotFoundException("Student not found!")
        }

        val memorization = Memorization(
            id = null,
            student = studentOptional.get(),
            memorizationType = getMemorizationType(payload.memorizationType.orEmpty()),
            juz = payload.juz,
            page = payload.page,
            memorizationValue = payload.memorizationValue,
            recitationValue = payload.recitationValue,
            category = payload.category,
            createdAt= LocalDateTime.now(),
            updatedAt = null
        )

        return memorizationRepository.save(memorization)
    }

    fun getMemorizationType(str: String): MemorizationType {
        if (str.equals(1)){
            return MemorizationType.ZIYADAH
        }
        return MemorizationType.MUROJAAH
    }

    fun findAllMemorizations(): List<Memorization> = memorizationRepository.findAll()

}