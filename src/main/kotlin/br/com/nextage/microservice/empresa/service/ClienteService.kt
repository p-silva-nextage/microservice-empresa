package br.com.nextage.microservice.empresa.service

import br.com.nextage.microservice.empresa.dto.ClienteDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ClienteService {

    fun save(clienteDTO: ClienteDTO): ClienteDTO?

    fun findById(id: Long?): ClienteDTO?

    fun deleteById(id: Long)

    fun findAllFields(search: String?, page: Pageable?): Page<ClienteDTO>

    fun findAll(page: Pageable?): Page<ClienteDTO>

    fun findByEmpresaId(empresaId: Long?): List<ClienteDTO>?
}
