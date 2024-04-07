package br.com.estacionamento.service;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.estacionamento.dtos.EstabelecimentoDTO;
import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.repository.EstabelecimentoRepository;

import java.util.List;


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

    public Page<EstabelecimentoDTO> listar(Pageable paginacao) {

        if (paginacao == null || paginacao.getPageNumber() < 0 || paginacao.getPageSize() <= 0) {
            throw new IllegalArgumentException("Paginação inválida!");
        }

        return estabelecimentoRepository.
                findAll(paginacao).map(e -> modelMapper.map(e, EstabelecimentoDTO.class));

    }

    public EstabelecimentoDTO listarPorId(Long id) {

        Estabelecimento estabelecimento = estabelecimentoRepository.
                findById(id).orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(estabelecimento, EstabelecimentoDTO.class);
    }
}
