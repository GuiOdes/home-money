package com.guidoes.homemoney.infra.database.repository.jpa

import com.guidoes.homemoney.infra.database.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository: JpaRepository<UserEntity, Long>
