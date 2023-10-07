package br.com.nextage.microservice.empresa.controller

import br.com.nextage.microservice.empresa.dto.CategoriaProdutoDTO
import br.com.nextage.microservice.empresa.service.CategoriaProdutoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categoria-produto")
class CategoriaProdutoController {

    @Autowired
    private lateinit var categoriaProdutoService: CategoriaProdutoService

    @PostMapping(value = ["/v1/"])
    fun save(@RequestBody categoriaProdutoDTO: CategoriaProdutoDTO): ResponseEntity<CategoriaProdutoDTO?> {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaProdutoService.save(categoriaProdutoDTO))
    }

    @GetMapping(value = ["/v1/{id}/"])
    fun findById(@PathVariable("id") id: Long): ResponseEntity<CategoriaProdutoDTO?> {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaProdutoService.findById(id))
    }

    @DeleteMapping(value = ["/v1/{id}/"])
    @ResponseStatus(value = HttpStatus.OK)
    fun deleteById(@PathVariable("id") id: Long) {
        categoriaProdutoService.deleteById(id)
    }

    @GetMapping(value = ["/v1/"])
    fun list(@RequestParam search: String?, page: Pageable?): Page<CategoriaProdutoDTO> {
        return if (search?.isNotBlank() == true)
            categoriaProdutoService.findAllFields(search, page)
        else
            categoriaProdutoService.findAll(page)
    }

    @GetMapping(value = ["/buscar-empresa/v1/{id}/"])
    fun findByEmpresaId(@PathVariable("id") id: Long): ResponseEntity<List<CategoriaProdutoDTO>?> {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaProdutoService.findByEmpresaId(id))
    }
}
