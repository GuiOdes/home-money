package com.guidoes.homemoney.application.service

import com.guidoes.homemoney.application.repository.ExpenseRepository
import com.guidoes.homemoney.domain.model.Expense

class ExpenseService (
    private val expenseRepository: ExpenseRepository
) {

    fun save(expense: Expense, userId: Long): Expense {
        return expenseRepository.save(expense, userId)
    }

    fun findAll(): List<Expense> {
        return expenseRepository.findAll()
    }

    fun findAllByPeriod(userId: Long, daysBeforeToday: Int): List<Expense> {
        return expenseRepository.findAllByPeriod(userId, daysBeforeToday)
    }
}