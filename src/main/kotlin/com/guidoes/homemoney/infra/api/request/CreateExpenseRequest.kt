package com.guidoes.homemoney.infra.api.request

import com.guidoes.homemoney.domain.enums.ExpenseType
import java.math.BigDecimal

data class CreateExpenseRequest (
    val description: String,
    val value: BigDecimal,
    val type: ExpenseType,
    val isRecurrence: Boolean,
    val recurrencePeriodInMonths: Int = 0,
    val userId: Long
)
