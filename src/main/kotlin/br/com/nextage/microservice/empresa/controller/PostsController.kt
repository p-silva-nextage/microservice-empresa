package br.com.nextage.microservice.empresa.controller

import br.com.nextage.microservice.empresa.dto.PostsDTO
import br.com.nextage.microservice.empresa.service.PostsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostsController {

    @Autowired
    private lateinit var postsService: PostsService

    @PostMapping(value = ["/v1/"])
    fun save(@RequestBody postsDTO: PostsDTO): ResponseEntity<PostsDTO?> =
            ResponseEntity.status(HttpStatus.CREATED).body(postsService.save(postsDTO))

    @GetMapping(value = ["/v1/{id}/"])
    fun findById(@PathVariable("id") id: Long): ResponseEntity<PostsDTO?> =
            ResponseEntity.status(HttpStatus.OK).body(postsService.findById(id))

    @GetMapping(value = ["/v1/"])
    fun list(): ResponseEntity<List<PostsDTO>?> =
            ResponseEntity.status(HttpStatus.OK).body(postsService.listAll())
}
