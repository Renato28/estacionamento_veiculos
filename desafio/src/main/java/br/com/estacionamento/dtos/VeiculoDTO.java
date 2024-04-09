package br.com.estacionamento.dtos;

import br.com.estacionamento.model.Tipo;
import lombok.Getter;

@Getter
public class VeiculoDTO {

    public VeiculoDTO(String message) {
        //TODO Auto-generated constructor stub
    }
    private Long id;
    private String marca;
    private String modelo;
    private String cor;
    private String placa;
    private Tipo tipo;
}
