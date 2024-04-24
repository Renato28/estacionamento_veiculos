package br.com.estacionamento.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registro_estacionamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroEstacionamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Estabelecimento estabelecimento;
    @ManyToOne
    private Veiculo veiculo;

    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private TipoRegistro tipoRegistro;
}
