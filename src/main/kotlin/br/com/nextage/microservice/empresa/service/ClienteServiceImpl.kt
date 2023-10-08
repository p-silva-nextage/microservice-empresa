package br.com.nextage.microservice.empresa.service

import br.com.nextage.microservice.empresa.dto.ClienteDTO
import br.com.nextage.microservice.empresa.exception.CustomException
import br.com.nextage.microservice.empresa.extensions.getMessage
import br.com.nextage.microservice.empresa.model.EmpresaEntity
import br.com.nextage.microservice.empresa.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class ClienteServiceImpl :ClienteService {

    @Autowired
    private lateinit var clienteRepository: ClienteRepository

    @Autowired
    private lateinit var empresaService: EmpresaService

    @Autowired
    private lateinit var messageSource: MessageSource

    override fun save(clienteDTO: ClienteDTO): ClienteDTO? {
        val empresa = empresaService.findById(clienteDTO.empresa?.id)
        if (empresa?.id != null) {
            clienteDTO.empresa = empresa
        } else {
            throw CustomException(HttpStatus.NOT_FOUND, messageSource.getMessage("empresa.nao.existe"))
        }
        return ClienteDTO((clienteRepository.save(clienteDTO.toEntity())))
    }

    override fun findById(id: Long?): ClienteDTO? {
        return ClienteDTO(clienteRepository.findByIdOrNull(id))
    }

    override fun deleteById(id: Long) {
        clienteRepository.deleteById(id)
    }

    override fun findAllFields(search: String?, page: Pageable?): Page<ClienteDTO> {
        return clienteRepository.findAllFields(search, page).map { ClienteDTO(it) }
    }

    override fun findAll(page: Pageable?): Page<ClienteDTO> {
        return clienteRepository.findAll(null, page).map { ClienteDTO(it) }
    }

    override fun findByEmpresaId(empresaId: Long?): List<ClienteDTO>? {
        return clienteRepository.findByEmpresa(EmpresaEntity(empresaId))?.map { ClienteDTO(it) }
    }
}
