package br.com.nextage.microservice.empresa.dto

import br.com.nextage.microservice.empresa.model.EmpresaEntity

data class EmpresaDTO(
        var id: Long? = null,
        var nome: String? = null,
        var nomeFantasia: String? = null,
        var email: String? = null,
        var cnpj: String? = null,
) {
    constructor(empresaEntity: EmpresaEntity?) : this() {
        this.id = empresaEntity?.id
        this.nome = empresaEntity?.nome
        this.nomeFantasia = empresaEntity?.nomeFantasia
        this.email = empresaEntity?.email
        this.cnpj = empresaEntity?.cnpj
    }

    fun toEntity(): EmpresaEntity {
        return EmpresaEntity(
                this.id,
                this.nome,
                this.nomeFantasia,
                this.email,
                this.cnpj
        )
    }
}