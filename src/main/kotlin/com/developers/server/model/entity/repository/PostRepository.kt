package com.developers.server.model.entity.repository

import com.developers.server.model.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
}