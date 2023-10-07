package br.com.nextage.microservice.empresa.integration


import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder

open class GenericServiceIntegration {

    fun <T> getIntegrationToEntity(
            webClient: WebClient,
            url: String,
            path: String,
            pathSegment: String,
            typeClass: Class<T>
    ): T? {
        return webClient
                .get()
                .uri(
                        UriComponentsBuilder
                                .fromHttpUrl(url)
                                .path(path)
                                .pathSegment(pathSegment)
                                .build()
                                .toUri()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(typeClass)
                .block()?.body
    }

    fun <T> getIntegrationToCollectList(
            webClient: WebClient,
            url: String,
            path: String,
            typeClass: Class<T>,
    ): MutableList<T>? {
        return webClient
                .get()
                .uri(
                        UriComponentsBuilder
                                .fromHttpUrl(url)
                                .path(path)
                                .build()
                                .toUri()
                )
                .retrieve()
                .bodyToFlux(typeClass)
                .collectList()
                .block()
    }

    fun <T> postIntegrationFromValue(
            webClient: WebClient,
            url: String,
            path: String,
            formValue: Any,
            typeClass: Class<T>
    ): T? {
        return webClient
                .post()
                .uri(
                        UriComponentsBuilder
                                .fromHttpUrl(url)
                                .path(path)
                                .build()
                                .toUri()
                )
                .body(BodyInserters.fromValue(formValue))
                .retrieve()
                .bodyToMono(typeClass)
                .block()?.let {
                    return it
                }
    }
}