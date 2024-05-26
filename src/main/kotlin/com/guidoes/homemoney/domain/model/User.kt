package com.guidoes.homemoney.domain.model

data class User(
    val id: Long? = null,
    val name: String,
    val expenses: List<Expense> = emptyList()
) {
    val totalExpenses get() = expenses.sumOf { it.value }
}
