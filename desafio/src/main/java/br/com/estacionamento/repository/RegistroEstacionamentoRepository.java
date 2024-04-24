package br.com.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.model.RegistroEstacionamento;

@Repository
public interface RegistroEstacionamentoRepository  extends JpaRepository<RegistroEstacionamento,Long>{
    
}
