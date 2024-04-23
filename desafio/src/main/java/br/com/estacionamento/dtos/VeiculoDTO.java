package br.com.estacionamento.dtos;

import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.model.Tipo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "Este campo é de preenchimento obrigatório")
    private String marca;
    @NotBlank(message = "Este campo é de preenchimento obrigatório")
    private String modelo;
    @NotBlank(message = "Este campo é de preenchimento obrigatório")
    private String cor;
    @Pattern(regexp = "^[A-Z]{3}-?[0-9]{4}$")
    @NotBlank(message = "Este campo é de preenchimento obrigatório")
    private String placa;
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @NotNull(message = "Este campo é de preenchimento obrigatório")
    private Long idEstabelecimento;

    public VeiculoDTO(String message) {
        //TODO Auto-generated constructor stub
    }
}

