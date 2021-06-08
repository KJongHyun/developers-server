package com.developers.server.model.entity

import com.developers.server.model.dto.post.ModifyPostRequestDto
import javax.persistence.*

@Entity
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    val id: Long? = null,
    var title: String,
    var contents: String = ""
) : BaseEntity() {

    fun update(modifyPostRequestDto: ModifyPostRequestDto) {
        this.title = modifyPostRequestDto.title
        this.contents = modifyPostRequestDto.contents
    }

}