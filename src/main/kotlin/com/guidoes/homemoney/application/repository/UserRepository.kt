package com.guidoes.homemoney.application.repository

import com.guidoes.homemoney.domain.model.User

interface UserRepository {
    fun save(user: User): User
    fun findAll(): List<User>
    fun findById(id: Long): User?
}
