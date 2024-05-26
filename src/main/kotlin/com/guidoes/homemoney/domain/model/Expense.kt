package com.guidoes.homemoney.domain.model

import com.guidoes.homemoney.domain.enums.ExpenseType
import java.time.LocalDateTime

data class Expense(
    val id: Long,
    val description: String,
    val value: Double,
    val type: ExpenseType,
    val isRecurrence: Boolean,
    val creationDate: LocalDateTime,
    val recurrencePeriodInMonths: Int?
)
