package br.com.estacionamento.controller;

import br.com.estacionamento.dtos.EstacionamentoCadastroDTO;
import br.com.estacionamento.service.EstacionamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

    @Autowired
    public EstacionamentoService estacionamentoService;

    @Transactional
    @PostMapping
    public ResponseEntity<EstacionamentoCadastroDTO> cadastrar(@Valid @RequestBody EstacionamentoCadastroDTO dto, UriComponentsBuilder componentsBuilder) {
        EstacionamentoCadastroDTO estabelecimentoDTO = estacionamentoService.cadastroEstabelecimento(dto);

        URI endereco = componentsBuilder.path("/estabelecimento/{id}").buildAndExpand(estabelecimentoDTO.getId()).toUri();

        return ResponseEntity.created(endereco).body(estabelecimentoDTO);
    }

}