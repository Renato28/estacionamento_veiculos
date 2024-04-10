package br.com.estacionamento.dtos;

import br.com.estacionamento.model.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {


    private Long id;
    private String marca;
    private String modelo;
    private String cor;
    private String placa;
    private Tipo tipo;
    private EstabelecimentoDTO estabelecimento;

    public VeiculoDTO(String message) {
        //TODO Auto-generated constructor stub
    }
}

