package br.com.nextage.microservice.empresa.model

import br.com.nextage.microservice.empresa.enums.TipoPessoa
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "cliente")
data class ClienteEntity(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column(name = "nome")
        var nome: String? = null,
        @Column(name = "cpf_cnpj")
        var cpfCnpj: String? = null,
        @Enumerated(EnumType.STRING)
        @Column(name = "tipo_pessoa")
        var tipoPessoa: TipoPessoa? = null,
        @Column(name = "email")
        var email: String? = null,
        @Column(name = "numero_telefone")
        var numeroTelefone: String? = null,
        @NotNull
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "empresa_id")
        var empresa: EmpresaEntity? = null
) : Serializable