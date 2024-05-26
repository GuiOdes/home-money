package com.guidoes.homemoney.application.service

import com.guidoes.homemoney.application.repository.ExpenseRepository
import com.guidoes.homemoney.domain.model.Expense
import com.guidoes.homemoney.infra.api.request.CreateExpenseRequest
import com.guidoes.homemoney.infra.api.request.CreateSharedExpenseRequest
import com.guidoes.homemoney.utils.converter.ExpenseConverter.toModel
import java.math.MathContext

class ExpenseService (
    private val expenseRepository: ExpenseRepository
) {

    fun save(request: CreateExpenseRequest): Expense {
        return expenseRepository.save(request.toModel(), request.userId)
    }

    fun createSharedExpense(request: CreateSharedExpenseRequest) {
        if (request.users.sumOf { it.percentage } != 100) {
            throw IllegalArgumentException("The sum of the percentages must be 100")
        }

        request.users.forEach {
            val value = request.value * (it.percentage / 100.0).toBigDecimal().round(MathContext(2))

            expenseRepository.save(request.toModel(value, it.percentage), it.userId)
        }
    }

    fun findAll(): List<Expense> {
        return expenseRepository.findAll()
    }

    fun findAllByPeriod(userId: Long, daysBeforeToday: Int): List<Expense> {
        return expenseRepository.findAllByPeriod(userId, daysBeforeToday)
    }
}