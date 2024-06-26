package br.com.estacionamento.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.estacionamento.dtos.VeiculoDTO;
import br.com.estacionamento.service.VeiculoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Transactional
    @PostMapping
    public ResponseEntity<VeiculoDTO> cadastrar(@Valid @RequestBody VeiculoDTO dto, UriComponentsBuilder componentsBuilder) {
        VeiculoDTO veiculoDTO;

        try {
            veiculoDTO = veiculoService.cadastrar(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new VeiculoDTO(e.getMessage()));
        }

        URI endereco = componentsBuilder.path("/veiculo/{id}").buildAndExpand(veiculoDTO.getId()).toUri();
        return ResponseEntity.created(endereco).body(veiculoDTO);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid VeiculoDTO dto) {
        VeiculoDTO veiculoDTO;
        try {
            veiculoDTO = veiculoService.atualizar(id, dto);
        } catch (RuntimeException erro) {
            return ResponseEntity.badRequest().body(new VeiculoDTO(erro.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<VeiculoDTO>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        Page<VeiculoDTO> veiculoDTO;
        try {
            veiculoDTO = veiculoService.listar(paginacao);
        } catch (RuntimeException erro) {
            throw new RuntimeException("Erro ao listar o veiculo", erro);
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> detalhar(@PathVariable Long id) {
        VeiculoDTO dto = veiculoService.listarPorId(id);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<VeiculoDTO> excluir(@PathVariable @NotNull Long id) {

        veiculoService.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/find/{placa}")
    public ResponseEntity<VeiculoDTO> findPlaca(@PathVariable String placa) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(veiculoService.findbyPlaca(placa));
    }

}
