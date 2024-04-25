package br.com.estacionamento.dtos.response;

import br.com.estacionamento.dtos.EstabelecimentoDTO;
import br.com.estacionamento.dtos.VeiculoDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RegistroEstacionamentoResponseDTO {

    private Long id;
    private EstabelecimentoDTO estabelecimento;
    private VeiculoDTO veiculo;
    private LocalDateTime data;
    private String tipoRegistro;

}
