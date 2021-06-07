package com.developers.server.model.dto.comment

data class CommentsResponseDto(
    val list: List<CommentDto>
)

data class CommentDto(
    val postId: Long,
    val id: Long,
    val name: String,
    val email: String,
    val body: String
)
