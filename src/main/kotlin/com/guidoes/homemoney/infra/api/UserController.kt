package com.guidoes.homemoney.infra.api

import com.guidoes.homemoney.application.service.UserService
import com.guidoes.homemoney.infra.api.request.CreateUserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody request: CreateUserRequest) = userService.save(request)

    @GetMapping
    fun findAll() = userService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = userService.findById(id)
}