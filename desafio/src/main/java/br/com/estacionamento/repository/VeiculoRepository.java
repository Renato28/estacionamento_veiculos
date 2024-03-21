package br.com.estacionamento.repository;

import br.com.estacionamento.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {


}
