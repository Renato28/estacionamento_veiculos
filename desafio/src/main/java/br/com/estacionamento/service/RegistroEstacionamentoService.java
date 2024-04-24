package br.com.estacionamento.service;

import br.com.estacionamento.dtos.RegistroEstabelecimentoDTO;
import br.com.estacionamento.model.RegistroEstacionamento;
import br.com.estacionamento.repository.RegistroEstacionamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroEstacionamentoService {
    
   @Autowired
   private  RegistroEstacionamentoRepository registroEstacionamentoRepository ;

   @Autowired
   private ModelMapper mapper;

   public RegistroEstabelecimentoDTO registrarEntrada(RegistroEstabelecimentoDTO dto){

      RegistroEstacionamento registroEstacionamento = mapper.map(dto, RegistroEstacionamento.class);

      registroEstacionamentoRepository.save(registroEstacionamento);

      return mapper.map(registroEstacionamento, RegistroEstabelecimentoDTO.class);
   }

   public RegistroEstabelecimentoDTO registrarSaida(RegistroEstabelecimentoDTO dto){

      RegistroEstacionamento registroEstacionamento = mapper.map(dto, RegistroEstacionamento.class);

      registroEstacionamentoRepository.save(registroEstacionamento);

      return mapper.map(registroEstacionamento, RegistroEstabelecimentoDTO.class);
   }

}
