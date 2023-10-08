package br.com.nextage.microservice.empresa.dto

import br.com.nextage.microservice.empresa.enums.TipoPessoa
import br.com.nextage.microservice.empresa.model.ClienteEntity

data class ClienteDTO(
        var id: Long? = null,
        var nome: String? = null,
        var cpfCnpj: String? = null,
        var tipoPessoa: TipoPessoa? = null,
        var email: String? = null,
        var numeroTelefone: String? = null,
        var empresa: EmpresaDTO? = null
) {
    constructor(clienteEntity: ClienteEntity?) : this() {
        this.id = clienteEntity?.id
        this.nome = clienteEntity?.nome
        this.cpfCnpj = clienteEntity?.cpfCnpj
        this.tipoPessoa = clienteEntity?.tipoPessoa
        this.email = clienteEntity?.email
        this.numeroTelefone = clienteEntity?.numeroTelefone
        this.empresa = EmpresaDTO(clienteEntity?.empresa)
    }

    fun toEntity(): ClienteEntity {
        return ClienteEntity(
                this.id,
                this.nome,
                this.cpfCnpj,
                this.tipoPessoa,
                this.email,
                this.numeroTelefone,
                this.empresa?.toEntity()
        )
    }
}

