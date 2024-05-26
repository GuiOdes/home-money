package com.guidoes.homemoney.infra.database.repository.jpa

import com.guidoes.homemoney.infra.database.entity.ExpenseEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface ExpenseJpaRepository: JpaRepository<ExpenseEntity, Long> {
    fun findAllByCreationDateBetweenAndUserId(
        start: LocalDateTime,
        end: LocalDateTime,
        userId: Long
    ): List<ExpenseEntity>
}
