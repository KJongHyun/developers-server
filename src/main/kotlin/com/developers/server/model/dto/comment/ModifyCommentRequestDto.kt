package com.developers.server.model.dto.comment

data class ModifyCommentRequestDto(
    val commentId: Long,
    val body: String
)
