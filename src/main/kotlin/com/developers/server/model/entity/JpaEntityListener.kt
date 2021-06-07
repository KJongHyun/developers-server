package com.developers.server.model.entity

import java.time.LocalDateTime
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

class JpaEntityListener {
    @PrePersist
    fun created(baseEntity: BaseEntity) {
        baseEntity.createdBy = "community-server"
        baseEntity.createdAt = LocalDateTime.now()
        baseEntity.updatedAt = LocalDateTime.now()
    }

    @PreUpdate
    fun updated(baseEntity: BaseEntity) {
        baseEntity.updatedBy = "community-server"
        baseEntity.updatedAt = LocalDateTime.now()
    }
}