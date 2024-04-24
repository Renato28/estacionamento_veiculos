package br.com.estacionamento.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroEstacionamentoDTO {

    private Long id;
    private Long idEstabelecimento;
    private Long idVeiculo;

}
