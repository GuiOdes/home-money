package com.guidoes.homemoney.infra.database.repository

import com.guidoes.homemoney.application.repository.ExpenseRepository
import com.guidoes.homemoney.domain.model.Expense
import com.guidoes.homemoney.infra.database.repository.jpa.ExpenseJpaRepository
import com.guidoes.homemoney.infra.database.repository.jpa.UserJpaRepository
import com.guidoes.homemoney.utils.converter.ExpenseConverter.toEntity
import com.guidoes.homemoney.utils.converter.ExpenseConverter.toModel
import com.guidoes.homemoney.utils.extension.removeOutdatedExpenses
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.time.Period

@Repository
class ExpenseRepositoryImpl(
    private val expenseJpaRepository: ExpenseJpaRepository,
    private val userRepository: UserJpaRepository
): ExpenseRepository {
    override fun save(expense: Expense, userId: Long): Expense {
        val user = userRepository.findByIdOrNull(userId) ?: throw Exception("User not found")

        return expenseJpaRepository.save(expense.toEntity(user)).toModel()
    }

    override fun findAll(): List<Expense> {
        return expenseJpaRepository.findAll()
            .removeOutdatedExpenses()
            .map { it.toModel() }
    }

    override fun findAllByPeriod(userId: Long, daysBeforeToday: Int): List<Expense> {
        val initialDate = LocalDateTime.now().minus(Period.ofDays(daysBeforeToday))

        return expenseJpaRepository.findAllByCreationDateBetweenAndUserId(
            initialDate, LocalDateTime.now(), userId
        ).removeOutdatedExpenses().map { it.toModel() }
    }
}
