package br.com.estacionamento.dtos;

import br.com.estacionamento.model.Tipo;
import lombok.Getter;

@Getter
public class VeiculoCadastroDTO {

    private String marca;
    private String modelo;
    private String cor;
    private String placa;
    private Tipo tipo;
}
