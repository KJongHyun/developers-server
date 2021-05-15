package com.developers.server.model.dto

data class PostsResponseDto(
    val list: List<PostDto>
)

data class PostDto(
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String
)

