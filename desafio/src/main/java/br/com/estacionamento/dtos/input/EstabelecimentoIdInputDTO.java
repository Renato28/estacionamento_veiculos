package br.com.estacionamento.dtos.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstabelecimentoIdInputDTO {

    @NotNull(message = "O id do Estabelecimento é obrigatório")
    private Long id;

}
