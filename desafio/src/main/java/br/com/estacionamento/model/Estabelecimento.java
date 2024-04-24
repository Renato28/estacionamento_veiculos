package br.com.estacionamento.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private Integer quantidadeVagasMotos;
    private Integer quantidadeVagasCarros;

    @OneToMany(mappedBy="estabelecimento",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Veiculo> veiculos = new ArrayList<>();
    
    //@OneToMany(mappedBy="registro_estabelecimento",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    //private List<RegistroEstacionamento>registro = new ArrayList<>();
    
}

