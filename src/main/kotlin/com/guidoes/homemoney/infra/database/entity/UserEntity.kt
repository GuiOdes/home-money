package com.guidoes.homemoney.infra.database.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class UserEntity(
    @Id
    @GeneratedValue
    val id: Long? = null,
    val name: String,

    @OneToMany(mappedBy = "user")
    val expenses: List<ExpenseEntity>
)
