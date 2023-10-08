package br.com.nextage.microservice.empresa.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "empresa")
data class EmpresaEntity(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column(name = "nome")
        var nome: String? = null,
        @Column(name = "nome_fantasia")
        var nomeFantasia: String? = null,
        @Column(name = "email")
        var email: String? = null,
        @Column(name = "cnpj")
        var cnpj: String? = null,
        @OneToMany(mappedBy = "empresa", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        var categorias: List<ClienteEntity> = mutableListOf()
) : Serializable