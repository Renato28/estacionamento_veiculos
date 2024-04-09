package br.com.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estacionamento.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
