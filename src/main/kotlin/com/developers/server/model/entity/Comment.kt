package com.developers.server.model.entity

import javax.persistence.*

@Entity
data class Comment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    val id: Long? = null,
    @Column(name = "post_id")
    val postId: Long,
    val body: String
) : BaseEntity()
