package com.guidoes.homemoney.infra.database.entity

import com.guidoes.homemoney.domain.enums.ExpenseType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
class ExpenseEntity(
    @Id
    @GeneratedValue
    val id: Long,

    val description: String,

    val value: Double,

    val type: ExpenseType,

    val isRecurrence: Boolean,

    @CreationTimestamp
    val creationDate: LocalDateTime,

    val recurrencePeriodInMonths: Int?,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity
)
