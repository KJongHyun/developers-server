package com.developers.server.model.dto

data class CommentsResponseDto(
    val list: List<Comment>
)

data class Comment(
    val postId: Long,
    val id: Long,
    val name: String,
    val email: String,
    val body: String
)
