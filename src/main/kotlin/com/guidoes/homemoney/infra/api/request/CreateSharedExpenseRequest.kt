package com.guidoes.homemoney.infra.api.request

import com.guidoes.homemoney.domain.enums.ExpenseType
import java.math.BigDecimal

data class CreateSharedExpenseRequest(
    val description: String,
    val value: BigDecimal,
    val type: ExpenseType,
    val recurrencePeriodInMonths: Int = 0,
    val users: List<ExpenseUserRequest>
) {

    data class ExpenseUserRequest(
        val userId: Long,
        val percentage: Int
    )
}
