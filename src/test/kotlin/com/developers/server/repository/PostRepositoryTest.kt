package com.developers.server.repository

import com.developers.server.model.entity.Comment
import com.developers.server.model.entity.Post
import com.developers.server.model.entity.repository.CommentRepository
import com.developers.server.model.entity.repository.PostRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.Commit

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Commit
internal class PostRepositoryTest {

    @Autowired
    private lateinit var postRepository: PostRepository

    @Autowired
    private lateinit var commentRepository: CommentRepository

    @BeforeEach()
    fun beforeEach() {
//        val post = Post(title = "테스트 게시글", contents = "테스트 본문")
//
//        postRepository.save(post)
//
//        commentRepository.save(Comment(post = post, body = "댓글 내용1"))
//        commentRepository.save(Comment(post = post, body = "댓글 내용2"))
//        commentRepository.save(Comment(post = post, body = "댓글 내용3"))
//        commentRepository.save(Comment(post = post, body = "댓글 내용4"))
    }

    @Test
    @DisplayName("게시글(댓글 포함) 가져오기")
    fun findByPost() {
        val post = postRepository.findById(2).get()
        assertEquals(4, post!!.comments.size)
    }
}