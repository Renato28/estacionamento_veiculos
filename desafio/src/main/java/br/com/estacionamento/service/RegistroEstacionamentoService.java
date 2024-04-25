package br.com.estacionamento.service;

import br.com.estacionamento.dtos.EstabelecimentoDTO;
import br.com.estacionamento.dtos.VeiculoDTO;
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
   private EstabelecimentoService estabelecimentoService;

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
      EstabelecimentoDTO dto = estabelecimentoService.listarPorId(idEstabelecimento);
      return mapper.map(dto, Estabelecimento.class);
   }

   private Veiculo buscarVeiculo(Long idVeiculo) {
      VeiculoDTO dto = veiculoService.listarPorId(idVeiculo);
      return mapper.map(dto, Veiculo.class);
   }

}
