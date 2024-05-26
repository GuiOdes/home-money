package com.guidoes.homemoney.utils.converter

import com.guidoes.homemoney.domain.model.Expense
import com.guidoes.homemoney.domain.model.User
import com.guidoes.homemoney.infra.database.entity.ExpenseEntity
import com.guidoes.homemoney.infra.database.entity.UserEntity

object UserConverter {
    fun UserEntity.toModel(expenseList: List<Expense>) = User(
        id = id,
        name = name,
        expenses = expenseList
    )

    fun User.toEntity(
        expenseList: List<ExpenseEntity>
    ) = UserEntity(
        id = id,
        name = name,
        expenses = expenseList
    )
}