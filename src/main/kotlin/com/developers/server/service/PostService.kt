package com.developers.server.service

import com.developers.server.CmLogger
import com.developers.server.exception.CommunityException
import com.developers.server.exception.ErrorCode
import com.developers.server.model.dto.post.PostDto
import com.developers.server.model.dto.post.PostsRequestDto
import com.developers.server.model.dto.post.PostsResponseDto
import com.developers.server.model.entity.Post
import com.developers.server.model.entity.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {

    companion object : CmLogger

    suspend fun enrollPost(postsRequestDto: PostsRequestDto) {
        postRepository.save(
            Post(title = postsRequestDto.title!!, contents = postsRequestDto.contents!!)
        )
    }

    suspend fun readPost(id: Long): PostDto {
        val post = postRepository.findById(id).orElseThrow {
            throw CommunityException(ErrorCode.NOT_EXIST_POST)
        }

        return PostDto(
            userId = 1,
            id = post.id!!,
            title = post.title,
            contents = post.contents
        )
    }

    suspend fun modifyPost(postsRequestDto: PostsRequestDto) {
        TODO("Not yet implemented")
    }

    suspend fun deletePost(postId: Long) {
        TODO("Not yet implemented")
    }

    suspend fun posts(): PostsResponseDto {
        postRepository.findAll().map { post ->
            PostDto(0, post.id!!, post.title, post.contents)
        }.let { postDtoList ->
            log.info("postDtoList -> $postDtoList")
            return PostsResponseDto(list = postDtoList)
        }
    }

    fun deleteComment(commentId: Long) {
        TODO("Not yet implemented")
    }

}