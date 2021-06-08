package com.developers.server.model.dto.comment

data class CommentsResponseDto(
    val list: List<CommentDto>
)

data class CommentDto(
    val id: Long,
    val postId: Long,
    val name: String,
    val email: String,
    val body: String
)
