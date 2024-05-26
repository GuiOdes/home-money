package com.guidoes.homemoney.infra.configuration

import com.guidoes.homemoney.application.repository.ExpenseRepository
import com.guidoes.homemoney.application.repository.UserRepository
import com.guidoes.homemoney.application.service.ExpenseService
import com.guidoes.homemoney.application.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ServiceConfiguration {

    @Bean
    fun expenseService(
        expenseRepository: ExpenseRepository
    ) = ExpenseService(
        expenseRepository = expenseRepository
    )

    @Bean
    fun userService(
        userRepository: UserRepository
    ) = UserService(
        userRepository = userRepository
    )
}
