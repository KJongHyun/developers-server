package com.developers.server.controller

import com.developers.server.Logger
import com.developers.server.model.dto.Comment
import com.developers.server.model.dto.PostDto
import com.developers.server.model.dto.PostsRequestDto
import com.developers.server.model.dto.PostsResponseDto
import com.developers.server.service.PostService
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.random.Random

@RestController
@RequestMapping("/posts")
class PostController(
    private val postService: PostService
) {

    companion object : Logger

    @PostMapping
    fun enrollPost(@RequestBody postsRequestDto: PostsRequestDto) {
        postService.enrollPost(postsRequestDto)
    }

    @GetMapping
    fun posts(): PostsResponseDto {
        return postService.posts()
    }

    @GetMapping("/{id}")
    fun readPost(@PathVariable id: Long): PostDto {
        return PostDto(
            userId = 1,
            id = 1,
            title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
        )
    }

    @GetMapping("/{id}/comments")
    fun comments(@PathVariable id: Long): List<Comment> {
        return listOf(
            randomComment(),
            randomComment(),
            randomComment(),
            randomComment(),
            randomComment()
        )
    }

    private fun randomComment(): Comment {
        return Comment(
            postId = 1,
            id = Random.nextLong(5),
            name = "alias odio sit-${Random.nextLong(5)}",
            email = "${UUID.randomUUID().toString().substring(0, 5)}@naver.com",
            body = UUID.randomUUID().toString()
        )
    }

}