package br.com.estacionamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "veiculo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String marca;
  private String modelo;
  private String cor;
  private String placa;

  @Enumerated(EnumType.STRING)
  private Tipo tipo;

  @ManyToOne
  private Estabelecimento estabelecimento;

    // @ManyToOne
    // @JoinColumn(name = "estabelecimento_id")
    // private Estabelecimento estabelecimento;

}
