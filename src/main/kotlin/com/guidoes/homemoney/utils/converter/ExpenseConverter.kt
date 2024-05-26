package com.guidoes.homemoney.utils.converter

import com.guidoes.homemoney.domain.model.Expense
import com.guidoes.homemoney.infra.api.request.CreateExpenseRequest
import com.guidoes.homemoney.infra.api.request.CreateSharedExpenseRequest
import com.guidoes.homemoney.infra.database.entity.ExpenseEntity
import com.guidoes.homemoney.infra.database.entity.UserEntity
import java.math.BigDecimal

object ExpenseConverter {
    fun ExpenseEntity.toModel() = Expense(
        id = id,
        description = description,
        value = value,
        type = type,
        recurrencePeriodInMonths = recurrencePeriodInMonths,
        creationDate = creationDate
    )

    fun Expense.toEntity(user: UserEntity) = ExpenseEntity(
        id = id,
        description = description,
        value = value,
        type = type,
        recurrencePeriodInMonths = recurrencePeriodInMonths,
        creationDate = creationDate,
        user = user
    )

    fun CreateExpenseRequest.toModel() = Expense(
        description = description,
        value = value,
        type = type,
        recurrencePeriodInMonths = recurrencePeriodInMonths
    )

    fun CreateSharedExpenseRequest.toModel(value: BigDecimal, percentage: Int) = Expense(
        description = "Conta compartilhada. Você pagou o equivalente a $percentage% do valor total. de R$ ${this.value}",
        value = value,
        type = type,
        recurrencePeriodInMonths = recurrencePeriodInMonths
    )
}