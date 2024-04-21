package br.com.estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estacionamento.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {


     @Query("select u from Veiculo u where u.placa like %?1%")
     List<Veiculo>findByPlaca(String placa);
}
