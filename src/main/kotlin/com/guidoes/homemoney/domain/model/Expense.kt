package com.guidoes.homemoney.domain.model

import com.guidoes.homemoney.domain.enums.ExpenseType
import java.math.BigDecimal
import java.time.LocalDateTime

data class Expense(
    val id: Long? = null,
    val description: String,
    val value: BigDecimal,
    val type: ExpenseType,
    val creationDate: LocalDateTime? = null,
    val recurrencePeriodInMonths: Int
) {
    val isRecurrence: Boolean get() = recurrencePeriodInMonths > 0
}
