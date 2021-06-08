package com.developers.server.model.dto.post

data class ModifyPostRequestDto(
    val postId: Long,
    val title: String,
    val contents: String
)