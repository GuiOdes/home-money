package com.guidoes.homemoney.application.service

import com.guidoes.homemoney.application.repository.UserRepository
import com.guidoes.homemoney.domain.model.User
import com.guidoes.homemoney.infra.api.request.CreateUserRequest

class UserService(
    private val userRepository: UserRepository
) {

    fun save(request: CreateUserRequest): User {
        return userRepository.save(User(name = request.name))
    }

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun findById(id: Long): User? {
        return userRepository.findById(id)
    }
}