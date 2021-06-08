package com.developers.server.controller

import com.developers.server.model.dto.comment.CommentsResponseDto
import com.developers.server.model.dto.comment.EnrollCommentRequestDto
import com.developers.server.model.dto.comment.ModifyCommentRequestDto
import com.developers.server.service.CommentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comments")
class CommentController(private val commentService: CommentService) {
    @PostMapping
    suspend fun enrollComment(enrollCommentRequestDto: EnrollCommentRequestDto) {
        commentService.enrollComment(enrollCommentRequestDto)
    }

    @PutMapping
    suspend fun modifyComment(modifyCommentRequestDto: ModifyCommentRequestDto) {
        commentService.modifyComment(modifyCommentRequestDto)
    }

    @DeleteMapping("/{commentId}")
    suspend fun deleteComment(@PathVariable commentId: Long) {
        commentService.deleteComment(commentId)
    }

    @GetMapping("/{postId}")
    suspend fun comments(@PathVariable postId: Long): CommentsResponseDto {
        return commentService.comments(postId)
    }
}