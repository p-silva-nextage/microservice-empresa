package br.com.nextage.microservice.empresa.dto

data class PostsDTO(
        var id: Long? = null,
        var userId: Long? = null,
        var title: String? = null,
        var body: String? = null,
        var completed: Boolean? = null

)