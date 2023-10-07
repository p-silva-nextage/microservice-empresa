package br.com.nextage.microservice.empresa.service

import br.com.nextage.microservice.empresa.dto.PostsDTO
import br.com.nextage.microservice.empresa.integration.GenericServiceIntegration
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class PostsServiceImpl(
        @Qualifier("webClientLowerCamelCase")
        val webClientLowerCamelCase: WebClient,
) : GenericServiceIntegration(), PostsService {

    @Value("\${microservice.ms-jsonplaceholder.url}")
    private val url: String? = null

    @Value("\${microservice.ms-jsonplaceholder.path-posts}")
    private val pathPosts: String? = null
    override fun save(postsDTO: PostsDTO): PostsDTO? =
            postIntegrationFromValue(
                    webClientLowerCamelCase,
                    url!!,
                    pathPosts!!,
                    postsDTO,
                    PostsDTO::class.java
            )


    override fun findById(id: Long?): PostsDTO? =
            getIntegrationToEntity(
                    webClientLowerCamelCase,
                    url!!,
                    pathPosts!!,
                    id?.toString()!!,
                    PostsDTO::class.java
            )

    override fun listAll(): List<PostsDTO>? =
            getIntegrationToCollectList(
                    webClientLowerCamelCase,
                    url!!,
                    pathPosts!!,
                    PostsDTO::class.java
            )
}
