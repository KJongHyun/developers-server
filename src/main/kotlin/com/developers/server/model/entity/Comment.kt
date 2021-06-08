package com.developers.server.model.entity

import com.developers.server.model.dto.comment.ModifyCommentRequestDto
import javax.persistence.*

@Entity
data class Comment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    val id: Long? = null,
    @Column(name = "post_id")
    val postId: Long,
    var body: String
) : BaseEntity() {
    fun update(modifyCommentRequestDto: ModifyCommentRequestDto) {
        this.body = modifyCommentRequestDto.body
    }
}
