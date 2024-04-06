package br.com.estacionamento.service;

import br.com.estacionamento.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstacionamentoService {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;


}
