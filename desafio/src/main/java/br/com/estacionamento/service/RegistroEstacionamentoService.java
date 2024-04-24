package br.com.estacionamento.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estacionamento.model.RegistroEstacionamento;
import br.com.estacionamento.model.TipoRegistro;
import br.com.estacionamento.repository.RegistroEstacionamentoRepository;

@Service
public class RegistroEstacionamentoService {
    
   @Autowired
   private  RegistroEstacionamentoRepository registroEstacionamentoRepository ;
      


   public RegistroEstacionamento registrarEntrada(RegistroEstacionamento registroEstacionamento){

   registroEstacionamento.setData(LocalDateTime.now());   
   registroEstacionamento.setTipoRegistro(TipoRegistro.ENTRADA);


   return registroEstacionamentoRepository.save(registroEstacionamento);
   }

   public RegistroEstacionamento registrarSaida(RegistroEstacionamento registroEstacionamento){

      registroEstacionamento.setData(LocalDateTime.now());
      registroEstacionamento.setTipoRegistro(TipoRegistro.SAIDA);
      
      return registroEstacionamentoRepository.save(registroEstacionamento);
      
   }




}
