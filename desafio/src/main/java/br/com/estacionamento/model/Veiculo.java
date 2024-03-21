package br.com.estacionamento.model;

import br.com.estacionamento.model.Tipo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "veiculo")
@Getter
@Setter
@AllArgsConstructor
public class Veiculo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @NotNull(message = "Este campo é de preenchimento obrigatório")
  private String marca;
  @NotNull(message = "Este campo é de preenchimento obrigatório")
  private String modelo;
  @NotNull(message = "Este campo é de preenchimento obrigatório")
  private String cor;
  @NotNull(message = "Este campo é de preenchimento obrigatório")
  private String placa;
  @NotNull(message = "Este campo é de preenchimento obrigatório")
  @Enumerated(EnumType.STRING)
  private Tipo tipo;

}
