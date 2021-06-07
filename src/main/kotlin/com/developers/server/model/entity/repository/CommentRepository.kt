package com.developers.server.model.entity.repository

import com.developers.server.model.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
}