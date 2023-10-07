package br.com.nextage.microservice.empresa.controller

import br.com.nextage.microservice.empresa.dto.EmpresaDTO
import br.com.nextage.microservice.empresa.service.EmpresaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/empresa")
class EmpresaController {

    @Autowired
    private lateinit var empresaService: EmpresaService

    @PostMapping(value = ["/v1/"])
    fun save(@RequestBody empresaDTO: EmpresaDTO): ResponseEntity<EmpresaDTO?> {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresaDTO))
    }

    @PutMapping(value = ["/v1/"])
    fun update(@RequestBody empresaDTO: EmpresaDTO): ResponseEntity<EmpresaDTO?> {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.save(empresaDTO))
    }

    @GetMapping(value = ["/v1/{id}/"])
    fun findById(@PathVariable("id") id: Long): ResponseEntity<EmpresaDTO?> {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.findById(id))
    }

    @DeleteMapping(value = ["/v1/{id}/"])
    @ResponseStatus(value = HttpStatus.OK)
    fun deleteById(@PathVariable("id") id: Long) {
        empresaService.deleteById(id)
    }

    @GetMapping(value = ["/v1/"])
    fun list(@RequestParam search: String?, page: Pageable?): Page<EmpresaDTO> {
        return if (search?.isNotBlank() == true)
            empresaService.findAllFields(search, page)
        else
            empresaService.findAll(page)
    }
}
