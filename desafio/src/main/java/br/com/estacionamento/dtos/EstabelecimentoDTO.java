package br.com.estacionamento.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstabelecimentoDTO {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private Integer quantidadeVagasMotos;
    private Integer quantidadeVagasCarros;

    public EstabelecimentoDTO(String message) {
    }

}
