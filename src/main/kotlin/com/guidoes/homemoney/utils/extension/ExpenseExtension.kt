package com.guidoes.homemoney.utils.extension

import com.guidoes.homemoney.infra.database.entity.ExpenseEntity
import java.time.LocalDateTime

fun List<ExpenseEntity>.removeOutdatedExpenses(): List<ExpenseEntity> {
    return this.filter { it.creationDate!!.plusMonths(it.recurrencePeriodInMonths.toLong()) > LocalDateTime.now() }
}