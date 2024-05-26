package com.guidoes.homemoney.application.service

import com.guidoes.homemoney.application.repository.ExpenseRepository
import com.guidoes.homemoney.domain.model.Expense
import com.guidoes.homemoney.infra.api.request.CreateExpenseRequest
import com.guidoes.homemoney.utils.converter.ExpenseConverter.toModel

class ExpenseService (
    private val expenseRepository: ExpenseRepository
) {

    fun save(request: CreateExpenseRequest): Expense {
        return expenseRepository.save(request.toModel(), request.userId)
    }

    fun findAll(): List<Expense> {
        return expenseRepository.findAll()
    }

    fun findAllByPeriod(userId: Long, daysBeforeToday: Int): List<Expense> {
        return expenseRepository.findAllByPeriod(userId, daysBeforeToday)
    }
}