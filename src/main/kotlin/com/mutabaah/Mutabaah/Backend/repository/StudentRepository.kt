package com.mutabaah.Mutabaah.Backend.repository

import com.mutabaah.Mutabaah.Backend.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface StudentRepository: JpaRepository<Student, UUID> {
}