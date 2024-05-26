package com.guidoes.homemoney.application.repository

import com.guidoes.homemoney.domain.model.Expense

interface ExpenseRepository {
    fun save(expense: Expense, userId: Long): Expense
    fun findAll(): List<Expense>
    fun findAllByPeriod(userId: Long, daysBeforeToday: Int): List<Expense>
}
