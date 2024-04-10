package br.com.estacionamento.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estabelecimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private String nome;
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private String cnpj;
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private String endereco;
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private String telefone;
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private Integer quantidadeVagasMotos;
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private Integer quantidadeVagasCarros;

    @OneToMany(mappedBy = "estabelecimento",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Veiculo> veiculos = new ArrayList<>();
}
