package com.guidoes.homemoney.infra.api

import com.guidoes.homemoney.application.service.ExpenseService
import com.guidoes.homemoney.infra.api.request.CreateExpenseRequest
import com.guidoes.homemoney.infra.api.request.CreateSharedExpenseRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/expense")
class ExpenseController(
    private val expenseService: ExpenseService
) {

    @PostMapping
    fun save(@RequestBody request: CreateExpenseRequest) = expenseService.save(request)

    @PostMapping("/shared")
    fun createSharedExpense(
        @RequestBody request: CreateSharedExpenseRequest
    ) = expenseService.createSharedExpense(request)

    @GetMapping
    fun findAll() = expenseService.findAll()

    @GetMapping("/period/{days}/{userId}")
    fun findAllByPeriod(
        @PathVariable days: Int,
        @PathVariable userId: Long
    ) = expenseService.findAllByPeriod(userId, days)
}