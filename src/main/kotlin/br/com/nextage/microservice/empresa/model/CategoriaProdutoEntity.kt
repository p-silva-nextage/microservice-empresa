package br.com.nextage.microservice.empresa.model

import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "categoria_produto")
data class CategoriaProdutoEntity(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column(name = "nome")
        var nome: String? = null,
        @NotNull
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "empresa_id")
        var empresa: EmpresaEntity? = null
) : Serializable