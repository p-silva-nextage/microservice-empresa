package br.com.nextage.microservice.empresa.service

import br.com.nextage.microservice.empresa.dto.CategoriaProdutoDTO
import br.com.nextage.microservice.empresa.exception.CustomException
import br.com.nextage.microservice.empresa.extensions.getMessage
import br.com.nextage.microservice.empresa.model.EmpresaEntity
import br.com.nextage.microservice.empresa.repository.CategoriaProdutoRepository
import br.com.nextage.microservice.empresa.repository.EmpresaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class CategoriaProdutoServiceImpl :CategoriaProdutoService {

    @Autowired
    private lateinit var categoriaProdutoRepository: CategoriaProdutoRepository

    @Autowired
    private lateinit var empresaRepository: EmpresaRepository

    @Autowired
    private lateinit var empresaService: EmpresaService

    @Autowired
    private lateinit var messageSource: MessageSource

    override fun save(categoriaProdutoDTO: CategoriaProdutoDTO): CategoriaProdutoDTO? {
        val empresa = empresaService.findById(categoriaProdutoDTO.empresa?.id)
        if (empresa?.id != null) {
            categoriaProdutoDTO.empresa = empresa
        } else {
            throw CustomException(HttpStatus.NOT_FOUND, messageSource.getMessage("empresa.nao.existe"))
        }
        return CategoriaProdutoDTO((categoriaProdutoRepository.save(categoriaProdutoDTO.toEntity())))
    }

    override fun findById(id: Long?): CategoriaProdutoDTO? {
        return CategoriaProdutoDTO(categoriaProdutoRepository.findByIdOrNull(id))
    }

    override fun deleteById(id: Long) {
        categoriaProdutoRepository.deleteById(id)
    }

    override fun findAllFields(search: String?, page: Pageable?): Page<CategoriaProdutoDTO> {
        return categoriaProdutoRepository.findAllFields(search, page).map { CategoriaProdutoDTO(it) }
    }

    override fun findAll(page: Pageable?): Page<CategoriaProdutoDTO> {
        return categoriaProdutoRepository.findAll(null, page).map { CategoriaProdutoDTO(it) }
    }

    override fun findByEmpresaId(empresaId: Long?): List<CategoriaProdutoDTO>? {
        return categoriaProdutoRepository.findByEmpresa(EmpresaEntity(empresaId))?.map { CategoriaProdutoDTO(it) }
    }
}
