package com.developers.server.controller

import com.developers.server.CmLogger
import com.developers.server.model.dto.comment.CommentsResponseDto
import com.developers.server.model.dto.comment.EnrollCommentRequestDto
import com.developers.server.model.dto.comment.ModifyCommentRequestDto
import com.developers.server.model.dto.post.ModifyPostRequestDto
import com.developers.server.model.dto.post.PostDto
import com.developers.server.model.dto.post.PostsRequestDto
import com.developers.server.model.dto.post.PostsResponseDto
import com.developers.server.service.CommentService
import com.developers.server.service.PostService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController(private val postService: PostService) {

    companion object : CmLogger

    @PostMapping
    suspend fun enrollPost(@RequestBody postsRequestDto: PostsRequestDto) {
        postService.enrollPost(postsRequestDto)
    }

    @PutMapping
    suspend fun modifyPost(@RequestBody modifyPostRequestDto: ModifyPostRequestDto) {
        postService.modifyPost(modifyPostRequestDto)
    }

    @DeleteMapping("/{postId}")
    suspend fun deletePost(@PathVariable postId: Long) {
        postService.deletePost(postId)
    }

    @GetMapping
    suspend fun posts(): PostsResponseDto {
        return postService.posts()
    }

    @GetMapping("/{postId}")
    suspend fun readPost(@PathVariable postId: Long): PostDto {
        return postService.readPost(postId)
    }

}