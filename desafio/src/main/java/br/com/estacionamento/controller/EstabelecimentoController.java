package br.com.estacionamento.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.estacionamento.dtos.EstabelecimentoDTO;
import br.com.estacionamento.service.EstacionamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

    @Autowired
    public EstacionamentoService estacionamentoService;

    @Transactional
    @PostMapping
    public ResponseEntity<EstabelecimentoDTO> cadastrar(@Valid @RequestBody EstabelecimentoDTO dto, UriComponentsBuilder componentsBuilder) {
        EstabelecimentoDTO estabelecimentoDTO = estacionamentoService.cadastrar(dto);

        URI endereco = componentsBuilder.path("/estabelecimento/{id}").buildAndExpand(estabelecimentoDTO.getId()).toUri();

        return ResponseEntity.created(endereco).body(dto);
    }



    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<EstabelecimentoDTO>atualizar(@PathVariable @NotNull Long id ,@RequestBody @Valid EstabelecimentoDTO dto  ){
                
        EstabelecimentoDTO estabelecimentoAtualizado =  estacionamentoService.atualizar(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoAtualizado);
    }



}