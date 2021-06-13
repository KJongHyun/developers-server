package com.developers.server.service

import com.developers.server.CmLogger
import com.developers.server.ServerApplication
import com.developers.server.model.entity.Post
import com.developers.server.model.entity.QPost.post
import com.developers.server.model.entity.repository.PostRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*
import javax.persistence.EntityManager

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [ServerApplication::class])
internal class PostServiceTest : CmLogger {

    @Autowired
    lateinit var postRepository: PostRepository

    @Autowired
    lateinit var em: EntityManager

    @Autowired
    lateinit var queryFactory: JPAQueryFactory
}