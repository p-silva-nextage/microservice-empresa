package br.com.nextage.microservice.empresa.service

import br.com.nextage.microservice.empresa.dto.PostsDTO

interface PostsService {
    fun save(postsDTO: PostsDTO): PostsDTO?
    fun findById(id: Long?): PostsDTO?
    fun listAll(): List<PostsDTO>?
}
