package com.mutabaah.Mutabaah.Backend.service

import com.mutabaah.Mutabaah.Backend.entity.Student
import com.mutabaah.Mutabaah.Backend.exception.UserNotFoundException
import com.mutabaah.Mutabaah.Backend.repository.StudentRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StudentService(val studentRepository: StudentRepository) {

    fun findAllStudents(): List<Student> = studentRepository.findAll()

    fun findStudentById(id: UUID): Student = studentRepository.findById(id).orElseThrow{
        UserNotFoundException("Student not found")
    }

    fun saveStudent(student: Student): Student = studentRepository.save(student)

    fun deleteStudent(id: UUID): Boolean {
        return if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id)
            return true
        } else throw UserNotFoundException("user not found")
    }
}