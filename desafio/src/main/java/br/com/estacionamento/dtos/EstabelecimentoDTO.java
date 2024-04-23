package br.com.estacionamento.dtos;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstabelecimentoDTO {

    private Long id;
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private String nome;
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$")
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private String cnpj;
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private String endereco;
    @Pattern(regexp= "^\\(\\d{2}\\)\\s\\d{4}-\\d{4}$")
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private String telefone;
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private Integer quantidadeVagasMotos;
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private Integer quantidadeVagasCarros;

    public EstabelecimentoDTO(String message) {
    }

}
