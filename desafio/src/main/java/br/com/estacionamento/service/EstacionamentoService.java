package br.com.estacionamento.service;

import br.com.estacionamento.dtos.EstacionamentoCadastroDTO;
import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.repository.EstabelecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EstacionamentoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    public EstacionamentoCadastroDTO cadastroEstabelecimento(EstacionamentoCadastroDTO dto) {
        Estabelecimento estabelecimento = modelMapper.map(dto, Estabelecimento.class);
        estabelecimentoRepository.save(estabelecimento);

        return modelMapper.map(estabelecimento, EstacionamentoCadastroDTO.class);
    }

}
