package br.com.estacionamento.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RegistroEstabelecimentoDTO {

    @NotNull(message = "O id do Estabelecimento é obrigatório")
    private Long id;

    private Long idEstabelecimento;

    private Long idVeiculo;

    private LocalDateTime data;

    private String tipo;

}
