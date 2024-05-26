package com.guidoes.homemoney.domain.model

data class User(
    val id: Long,
    val name: String,
    val expenses: List<Expense>
)
