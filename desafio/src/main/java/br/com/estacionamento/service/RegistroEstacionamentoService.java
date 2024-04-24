package br.com.estacionamento.service;

import br.com.estacionamento.dtos.RegistroEstacionamentoDTO;
import br.com.estacionamento.dtos.input.RegistroEstacionamentoInputDTO;
import br.com.estacionamento.model.RegistroEstacionamento;
import br.com.estacionamento.model.TipoRegistro;
import br.com.estacionamento.repository.RegistroEstacionamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroEstacionamentoService {
    
   @Autowired
   private  RegistroEstacionamentoRepository registroEstacionamentoRepository ;

   @Autowired
   private ModelMapper mapper;

   public RegistroEstacionamentoDTO registrarEntrada(RegistroEstacionamentoInputDTO inputDTO){
      RegistroEstacionamento registroEstacionamento = mapper.map(inputDTO, RegistroEstacionamento.class);
      registroEstacionamento.setData(LocalDateTime.now());
      registroEstacionamento.setTipoRegistro(TipoRegistro.ENTRADA);

      registroEstacionamentoRepository.save(registroEstacionamento);

      return mapper.map(registroEstacionamento, RegistroEstacionamentoDTO.class);
   }

   public RegistroEstacionamentoDTO registrarSaida(RegistroEstacionamentoInputDTO inputDTO){
      RegistroEstacionamento registroEstacionamento = mapper.map(inputDTO, RegistroEstacionamento.class);
      registroEstacionamento.setData(LocalDateTime.now());
      registroEstacionamento.setTipoRegistro(TipoRegistro.SAIDA);

      registroEstacionamentoRepository.save(registroEstacionamento);

      return mapper.map(registroEstacionamento, RegistroEstacionamentoDTO.class);
   }

}
