package br.com.estacionamento.dtos.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroEstacionamentoInputDTO {

    @NotNull(message = "O Estabelecimento é obrigatório")
    private EstabelecimentoIdInputDTO estabelecimento;

    @NotNull(message = "O Veiculo é obrigatório")
    private VeiculoIdInputDTO veiculo;

}
