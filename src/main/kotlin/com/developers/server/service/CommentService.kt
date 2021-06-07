package com.developers.server.service

import com.developers.server.model.dto.comment.CommentDto
import com.developers.server.model.dto.comment.CommentsResponseDto
import com.developers.server.model.dto.comment.EnrollCommentRequestDto
import com.developers.server.model.entity.repository.CommentRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.random.Random

@Service
class CommentService(
    private val commentRepository: CommentRepository
) {

    suspend fun enrollComment(postId: Long, enrollCommentRequestDto: EnrollCommentRequestDto) {
        TODO("Not yet implemented")
    }

    suspend fun comments(postId: Long): CommentsResponseDto {
        return CommentsResponseDto(
            list = listOf(
                randomComment(),
                randomComment(),
                randomComment(),
                randomComment(),
                randomComment(),
            )
        )
    }

    suspend fun deleteComment(commentId: Long) {
        commentRepository.deleteById(commentId)
    }

    private fun randomComment(): CommentDto {
        return CommentDto(
            postId = 1,
            id = Random.nextLong(5),
            name = "alias odio sit-${Random.nextLong(5)}",
            email = "${UUID.randomUUID().toString().substring(0, 5)}@naver.com",
            body = UUID.randomUUID().toString()
        )
    }

}