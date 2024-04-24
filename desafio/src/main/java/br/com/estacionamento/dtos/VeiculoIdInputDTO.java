package br.com.estacionamento.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoIdInputDTO {

    @NotNull(message = "O id do Veiculo é obrigatório")
    private Long id;

}
