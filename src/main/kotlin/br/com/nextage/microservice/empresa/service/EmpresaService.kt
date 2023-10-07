package br.com.nextage.microservice.empresa.service

import br.com.nextage.microservice.empresa.dto.EmpresaDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface EmpresaService {

    fun save(empresaDTO: EmpresaDTO): EmpresaDTO?

    fun findById(id: Long?): EmpresaDTO?

    fun deleteById(id: Long)

    fun findAllFields(search: String?, page: Pageable?): Page<EmpresaDTO>

    fun findAll(page: Pageable?): Page<EmpresaDTO>
}
