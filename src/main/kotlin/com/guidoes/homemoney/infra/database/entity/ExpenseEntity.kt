package com.guidoes.homemoney.infra.database.entity

import com.guidoes.homemoney.domain.enums.ExpenseType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
class ExpenseEntity(
    @Id
    @GeneratedValue
    val id: Long? = null,

    val description: String,

    val value: BigDecimal,

    val type: ExpenseType,

    @CreationTimestamp
    val creationDate: LocalDateTime? = null,

    val recurrencePeriodInMonths: Int = 0,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity
)
