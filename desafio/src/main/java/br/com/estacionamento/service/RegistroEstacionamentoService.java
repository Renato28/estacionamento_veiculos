package br.com.estacionamento.service;

import br.com.estacionamento.dtos.request.RegistroEstacionamentoRequestDTO;
import br.com.estacionamento.dtos.response.RegistroEstacionamentoResponseDTO;
import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.model.RegistroEstacionamento;
import br.com.estacionamento.model.TipoRegistro;
import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.repository.RegistroEstacionamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroEstacionamentoService {

   @Autowired
   private ModelMapper mapper;
    
   @Autowired
   private RegistroEstacionamentoRepository registroEstacionamentoRepository ;

   @Autowired
   private EstacionamentoService estacionamentoService;

   @Autowired
   private VeiculoService veiculoService;

   public RegistroEstacionamentoResponseDTO registrarEntrada(RegistroEstacionamentoRequestDTO dto) {
      return registrar(dto, TipoRegistro.ENTRADA);
   }

   public RegistroEstacionamentoResponseDTO registrarSaida(RegistroEstacionamentoRequestDTO dto) {
      return registrar(dto, TipoRegistro.SAIDA);
   }

   private RegistroEstacionamentoResponseDTO registrar(RegistroEstacionamentoRequestDTO dto, TipoRegistro tipoRegistro) {
      Estabelecimento estabelecimento = buscarEstabelecimento(dto.getIdEstabelecimento());
      Veiculo veiculo = buscarVeiculo(dto.getIdVeiculo());

      RegistroEstacionamento registroEstacionamento = mapper.map(dto, RegistroEstacionamento.class);
      registroEstacionamento.setEstabelecimento(estabelecimento);
      registroEstacionamento.setVeiculo(veiculo);
      registroEstacionamento.setData(LocalDateTime.now());
      registroEstacionamento.setTipoRegistro(tipoRegistro);

      registroEstacionamentoRepository.save(registroEstacionamento);

      return mapper.map(registroEstacionamento, RegistroEstacionamentoResponseDTO.class);
   }

   private Estabelecimento buscarEstabelecimento(Long idEstabelecimento) {
      return estacionamentoService.buscarOuFalhar(idEstabelecimento);
   }

   private Veiculo buscarVeiculo(Long idVeiculo) {
      return veiculoService.buscarOuFalhar(idVeiculo);
   }

}
