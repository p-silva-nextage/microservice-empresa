package br.com.nextage.microservice.empresa.dto

import br.com.nextage.microservice.empresa.model.CategoriaProdutoEntity

data class CategoriaProdutoDTO(
        var id: Long? = null,
        var nome: String? = null,
        var empresa: EmpresaDTO? = null
) {
    constructor(categoriaProdutoEntity: CategoriaProdutoEntity?) : this() {
        this.id = categoriaProdutoEntity?.id
        this.nome = categoriaProdutoEntity?.nome
        this.empresa = EmpresaDTO(categoriaProdutoEntity?.empresa)
    }

    fun toEntity(): CategoriaProdutoEntity {
        return CategoriaProdutoEntity(
                this.id,
                this.nome,
                this.empresa?.toEntity()
        )
    }
}

