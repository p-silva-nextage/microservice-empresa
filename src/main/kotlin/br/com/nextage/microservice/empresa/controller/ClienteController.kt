package br.com.nextage.microservice.empresa.controller

import br.com.nextage.microservice.empresa.dto.ClienteDTO
import br.com.nextage.microservice.empresa.service.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cliente")
class ClienteController {

    @Autowired
    private lateinit var clienteService: ClienteService

    @PostMapping(value = ["/v1/"])
    fun save(@RequestBody clienteDTO: ClienteDTO): ResponseEntity<ClienteDTO?> {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteDTO))
    }

    @GetMapping(value = ["/v1/{id}/"])
    fun findById(@PathVariable("id") id: Long): ResponseEntity<ClienteDTO?> {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id))
    }

    @DeleteMapping(value = ["/v1/{id}/"])
    @ResponseStatus(value = HttpStatus.OK)
    fun deleteById(@PathVariable("id") id: Long) {
        clienteService.deleteById(id)
    }

    @GetMapping(value = ["/v1/"])
    fun list(@RequestParam search: String?, page: Pageable?): Page<ClienteDTO> {
        return if (search?.isNotBlank() == true)
            clienteService.findAllFields(search, page)
        else
            clienteService.findAll(page)
    }

    @GetMapping(value = ["/buscar-empresa/v1/{id}/"])
    fun findByEmpresaId(@PathVariable("id") id: Long): ResponseEntity<List<ClienteDTO>?> {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findByEmpresaId(id))
    }
}
