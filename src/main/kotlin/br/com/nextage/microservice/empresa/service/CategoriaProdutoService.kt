package br.com.nextage.microservice.empresa.service

import br.com.nextage.microservice.empresa.dto.CategoriaProdutoDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CategoriaProdutoService {

    fun save(categoriaProdutoDTO: CategoriaProdutoDTO): CategoriaProdutoDTO?

    fun findById(id: Long?): CategoriaProdutoDTO?

    fun deleteById(id: Long)

    fun findAllFields(search: String?, page: Pageable?): Page<CategoriaProdutoDTO>

    fun findAll(page: Pageable?): Page<CategoriaProdutoDTO>

    fun findByEmpresaId(empresaId: Long?): List<CategoriaProdutoDTO>?
}
