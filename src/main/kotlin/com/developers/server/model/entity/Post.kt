package com.developers.server.model.entity

import javax.persistence.*

@Entity
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    val id: Long? = null,
    val title: String,
    var contents: String = ""
) : BaseEntity()