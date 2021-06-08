package com.developers.server.service

import com.developers.server.exception.CommunityException
import com.developers.server.exception.ErrorCode
import com.developers.server.model.dto.comment.CommentDto
import com.developers.server.model.dto.comment.CommentsResponseDto
import com.developers.server.model.dto.comment.EnrollCommentRequestDto
import com.developers.server.model.dto.comment.ModifyCommentRequestDto
import com.developers.server.model.entity.Comment
import com.developers.server.model.entity.repository.CommentRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.random.Random

@Service
class CommentService(private val commentRepository: CommentRepository) {

    suspend fun enrollComment(enrollCommentRequestDto: EnrollCommentRequestDto) {
        Comment(postId = enrollCommentRequestDto.postId, body = enrollCommentRequestDto.body).let {
            commentRepository.save(it)
        }
    }

    suspend fun comments(postId: Long): CommentsResponseDto {
        return commentRepository.findByPostId(postId).map { comment ->
            CommentDto(
                id = comment.id!!,
                postId = comment.postId,
                name = "alias odio sit-${Random.nextLong(5)}",
                email = "${UUID.randomUUID().toString().substring(0, 5)}@naver.com",
                body = comment.body
            )
        }.let { CommentsResponseDto(it) }
    }

    suspend fun modifyComment(modifyCommentRequestDto: ModifyCommentRequestDto) {
        commentRepository.findById(modifyCommentRequestDto.commentId)
            .orElseThrow { throw CommunityException(ErrorCode.DATA_NOT_FOUND) }?.update(modifyCommentRequestDto)
    }

    suspend fun deleteComment(commentId: Long) {
        commentRepository.deleteById(commentId)
    }

}