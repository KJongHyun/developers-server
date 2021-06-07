package com.developers.server.model.entity

import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(JpaEntityListener::class)
open class BaseEntity(
    var createdAt: LocalDateTime? = null,
    var createdBy: String? = null,
    var updatedAt: LocalDateTime? = null,
    var updatedBy: String? = null
)