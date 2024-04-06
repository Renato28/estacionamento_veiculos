package br.com.estacionamento.controller;

import br.com.estacionamento.service.EstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estacionamento")
public class EstabelecimentoController {

    @Autowired
    public EstacionamentoService estacionamentoService;
}
