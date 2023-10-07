package br.com.nextage.microservice.empresa.repository

import br.com.nextage.microservice.empresa.model.EmpresaEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface EmpresaRepository : JpaRepository<EmpresaEntity, Long> {

    fun findAll(spec: Specification<EmpresaEntity?>?, page: Pageable?): Page<EmpresaEntity>

    @Query(
            """
            SELECT u FROM EmpresaEntity u WHERE
            (CAST(u.id as text) like upper(CONCAT('%',:search,'%')) 
            or upper(u.nome) like upper(CONCAT('%',:search,'%'))
            or upper(u.nomeFantasia) like upper(CONCAT('%',:search,'%'))
            or upper(u.email) like upper(CONCAT('%',:search,'%'))
            or upper(u.cnpj) like upper(CONCAT('%',:search,'%')))
        """
    )
    fun findAllFields(@Param("search") search: String?, page: Pageable?): Page<EmpresaEntity>
}