package br.com.estacionamento.dtos;

import lombok.Getter;

@Getter
public class EstacionamentoCadastroDTO {

    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private Integer quantidadeVagasMotos;
    private Integer quantidadeVagasCarros;
}
