package com.guidoes.homemoney.infra.api.response

import com.guidoes.homemoney.domain.model.Expense

data class UserResponse(
    val name: String,
    val expenses: List<Expense>
)
