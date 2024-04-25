package br.com.estacionamento.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.estacionamento.dtos.EstabelecimentoDTO;
import br.com.estacionamento.service.EstabelecimentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

    @Autowired
    public EstabelecimentoService estabelecimentoService;

    @Transactional
    @PostMapping
    public ResponseEntity<EstabelecimentoDTO> cadastrar(@Valid @RequestBody EstabelecimentoDTO dto, UriComponentsBuilder componentsBuilder) {
        EstabelecimentoDTO estabelecimentoDTO;

        try {
            estabelecimentoDTO = estabelecimentoService.cadastrar(dto);
        } catch (RuntimeException erro) {
            return ResponseEntity.badRequest().body(new EstabelecimentoDTO(erro.getMessage()));
        }

        URI endereco = componentsBuilder.path("/estabelecimento/{id}").buildAndExpand(estabelecimentoDTO.getId()).toUri();
        return ResponseEntity.created(endereco).body(estabelecimentoDTO);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<EstabelecimentoDTO> atualizar(@PathVariable @NotNull Long id ,@RequestBody @Valid EstabelecimentoDTO dto  ){
        EstabelecimentoDTO estabelecimentoAtualizado;
        try {
            estabelecimentoAtualizado = estabelecimentoService.atualizar(id, dto);
        }
        catch (RuntimeException erro) {
            return ResponseEntity.badRequest().body(new EstabelecimentoDTO(erro.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoAtualizado);
    }


    @GetMapping
    public ResponseEntity<Page<EstabelecimentoDTO>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        Page<EstabelecimentoDTO> estabelecimentoDTO;

        try {
            estabelecimentoDTO = estabelecimentoService.listar(paginacao);
        } catch (RuntimeException erro) {
            throw new RuntimeException("Erro ao listar o estabelecimento", erro);
        }

        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoDTO);
    }

     @GetMapping("/{id}")
     public ResponseEntity<EstabelecimentoDTO> detalhar(@PathVariable Long id) {
        EstabelecimentoDTO dto = estabelecimentoService.listarPorId(id);

        return ResponseEntity.ok(dto);
     }


     @DeleteMapping("/{id}")
     public ResponseEntity<EstabelecimentoDTO> excluir(@PathVariable @NotNull Long id){
            
          estabelecimentoService.excluir(id);

          return ResponseEntity.noContent().build();
     }

     

}