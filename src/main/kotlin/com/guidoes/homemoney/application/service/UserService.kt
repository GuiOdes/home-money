package com.guidoes.homemoney.application.service

import com.guidoes.homemoney.application.repository.UserRepository
import com.guidoes.homemoney.domain.model.User

class UserService(
    private val userRepository: UserRepository
) {

    fun save(user: User): User {
        return userRepository.save(user)
    }

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun findById(id: Long): User? {
        return userRepository.findById(id)
    }
}