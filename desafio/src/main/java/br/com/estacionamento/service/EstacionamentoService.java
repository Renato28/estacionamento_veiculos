package br.com.estacionamento.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estacionamento.dtos.EstabelecimentoDTO;
import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.repository.EstabelecimentoRepository;


@Service
public class EstacionamentoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    public EstabelecimentoDTO cadastrar(EstabelecimentoDTO dto) {
        Estabelecimento estabelecimento = modelMapper.map(dto, Estabelecimento.class);
        estabelecimentoRepository.save(estabelecimento);

        return modelMapper.map(estabelecimento, EstabelecimentoDTO.class);
    }


    public EstabelecimentoDTO atualizar(Long id, EstabelecimentoDTO dto){
        
        Estabelecimento estabelecimento = modelMapper.map(dto, Estabelecimento.class);
           
        estabelecimento.setId(id);

        estabelecimento = estabelecimentoRepository.save(estabelecimento);
 
        return modelMapper.map(estabelecimento, EstabelecimentoDTO.class); 
    }
}
