package com.developers.server.model.dto.comment

data class EnrollCommentRequestDto(
    val postId: Long,
    val body: String
)
