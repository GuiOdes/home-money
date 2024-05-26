package com.guidoes.homemoney.infra.database.repository

import com.guidoes.homemoney.application.repository.UserRepository
import com.guidoes.homemoney.domain.model.Expense
import com.guidoes.homemoney.domain.model.User
import com.guidoes.homemoney.infra.database.repository.jpa.UserJpaRepository
import com.guidoes.homemoney.utils.converter.ExpenseConverter.toModel
import com.guidoes.homemoney.utils.converter.UserConverter.toEntity
import com.guidoes.homemoney.utils.converter.UserConverter.toModel
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userJpaRepository: UserJpaRepository
) : UserRepository {
    override fun save(user: User): User {

        val userEntity = user.toEntity(emptyList())

        return userJpaRepository.save(userEntity).toModel(emptyList())
    }

    override fun findAll(): List<User> {
        return userJpaRepository.findAll().map { user ->
            val expenses = user.expenses.map { it.toModel() }

            user.toModel(expenses)
        }
    }

    override fun findById(id: Long): User? {
        return userJpaRepository.findByIdOrNull(id)?.let { user ->
            val expenses = user.expenses.map { it.toModel() }

            user.toModel(expenses)
        }
    }
}