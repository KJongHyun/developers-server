package com.developers.server.service

import com.developers.server.Logger
import com.developers.server.model.dto.PostDto
import com.developers.server.model.dto.PostsRequestDto
import com.developers.server.model.dto.PostsResponseDto
import com.developers.server.model.entity.Post
import com.developers.server.model.entity.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {

    companion object : Logger

    fun enrollPost(postsRequestDto: PostsRequestDto) {
        log.info("enrollPost -> $postsRequestDto")
        postRepository.save(
            Post(title = postsRequestDto.title!!, contents = postsRequestDto.contents!!)
        )
    }

    fun posts(): PostsResponseDto {
        log.info("posts -> ")
        postRepository.findAll().map {
            PostDto(0, 0, it.title, it.contents)
        }.apply {
            return PostsResponseDto(this)
        }
    }

}