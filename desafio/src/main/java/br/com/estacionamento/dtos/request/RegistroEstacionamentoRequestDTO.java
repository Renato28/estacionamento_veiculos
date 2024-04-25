package br.com.estacionamento.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroEstacionamentoRequestDTO {

    @NotNull(message = "O id do estabelecimento é obrigatório")
    private Long idEstabelecimento;

    @NotNull(message = "O id do veiculo é obrigatório")
    private Long idVeiculo;

}
