package br.com.nextage.microservice.empresa.service

import br.com.nextage.microservice.empresa.dto.EmpresaDTO
import br.com.nextage.microservice.empresa.exception.CustomException
import br.com.nextage.microservice.empresa.extensions.getMessage
import br.com.nextage.microservice.empresa.repository.EmpresaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl :EmpresaService {

    @Autowired
    private lateinit var empresaRepository: EmpresaRepository

    @Autowired
    private lateinit var messageSource: MessageSource

    override fun save(empresaDTO: EmpresaDTO): EmpresaDTO? {
        if (empresaDTO.id != null) {
            return update(empresaDTO)
        }
        return EmpresaDTO((empresaRepository.save(empresaDTO.toEntity())))
    }

    override fun findById(id: Long?): EmpresaDTO? {
        return EmpresaDTO(empresaRepository.findByIdOrNull(id))
    }

    override fun deleteById(id: Long) {
        empresaRepository.deleteById(id)
    }

    override fun findAllFields(search: String?, page: Pageable?): Page<EmpresaDTO> {
        return empresaRepository.findAllFields(search, page).map { EmpresaDTO(it) }
    }

    override fun findAll(page: Pageable?): Page<EmpresaDTO> {
        return empresaRepository.findAll(null, page).map { EmpresaDTO(it) }
    }

    private fun update(empresaDTO: EmpresaDTO): EmpresaDTO? {
        val empresa = empresaRepository.findById(empresaDTO.id!!)

        if (empresa.isPresent) {
            val empresaEntity = empresa.get()

            if (!empresaDTO.cnpj.isNullOrBlank()) {
                empresaEntity.cnpj = empresaDTO.cnpj
            }
            if (!empresaDTO.nome.isNullOrBlank()) {
                empresaEntity.nome = empresaDTO.nome
            }
            if (!empresaDTO.nomeFantasia.isNullOrBlank()) {
                empresaEntity.nomeFantasia = empresaDTO.nomeFantasia
            }
            if (!empresaDTO.email.isNullOrBlank()) {
                empresaEntity.email = empresaDTO.email
            }

            return EmpresaDTO(empresaRepository.save(empresaEntity))
        }
        throw CustomException(HttpStatus.NOT_FOUND, messageSource.getMessage("empresa.nao.existe"))
    }
}
