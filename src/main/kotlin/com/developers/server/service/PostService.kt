package com.developers.server.service

import com.developers.server.CmLogger
import com.developers.server.exception.CommunityException
import com.developers.server.exception.ErrorCode
import com.developers.server.model.dto.post.ModifyPostRequestDto
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
        Post(title = postsRequestDto.title, contents = postsRequestDto.contents).let {
            postRepository.save(it)
        }

    }

    suspend fun readPost(postId: Long): PostDto {
        val post = postRepository.findById(postId).orElseThrow { throw CommunityException(ErrorCode.DATA_NOT_FOUND, "post not found -> postId : $postId") }

        return PostDto(
            userId = 1,
            id = post.id!!,
            title = post.title,
            contents = post.contents
        )
    }

    suspend fun modifyPost(modifyPostRequestDto: ModifyPostRequestDto) {
        postRepository.findById(modifyPostRequestDto.postId).orElseThrow { throw CommunityException(ErrorCode.DATA_NOT_FOUND, "post not found -> postId : ${modifyPostRequestDto.postId}") }.update(modifyPostRequestDto)
    }

    suspend fun deletePost(postId: Long) {
        postRepository.deleteById(postId)
    }

    suspend fun posts(): PostsResponseDto {
        postRepository.findAll().map { post ->
            PostDto(0, post.id!!, post.title, post.contents)
        }.let { postDtoList ->
            log.info("postDtoList -> $postDtoList")
            return PostsResponseDto(list = postDtoList)
        }
    }
}