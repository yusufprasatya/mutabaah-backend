package com.mutabaah.Mutabaah.Backend.service

import com.mutabaah.Mutabaah.Backend.entity.User
import com.mutabaah.Mutabaah.Backend.exception.UserNotFoundException
import com.mutabaah.Mutabaah.Backend.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(val userRepository: UserRepository, val passwordEncoder: PasswordEncoder) {

    fun findAllUser(): List<User> = userRepository.findAll()

    fun findUserById(userId: UUID): User = userRepository.findById(userId).orElseThrow{
        UserNotFoundException("user not found")
    }

    fun saveUser(user: User): User {
        user.password = passwordEncoder.encode(user.password)
        print("user password" +user.password)
        return userRepository.save(user)
    }

    fun deleteUser(userId: UUID): Boolean {
        return if(userRepository.existsById(userId)) {
            userRepository.deleteById(userId)
            return true
        } else throw UserNotFoundException("user not found")
    }
}