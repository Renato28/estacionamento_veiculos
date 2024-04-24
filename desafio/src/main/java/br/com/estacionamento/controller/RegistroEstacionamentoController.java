package br.com.estacionamento.controller;

import br.com.estacionamento.dtos.RegistroEstacionamentoDTO;
import br.com.estacionamento.dtos.input.RegistroEstacionamentoInputDTO;
import br.com.estacionamento.service.RegistroEstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro/estacionamento")
public class RegistroEstacionamentoController {

    @Autowired
    private  RegistroEstacionamentoService registroEstacionamentoService;

    @PostMapping("/entrada")
    public ResponseEntity<RegistroEstacionamentoDTO>registrarEntrada(@RequestBody RegistroEstacionamentoInputDTO inputDto){
        RegistroEstacionamentoDTO registroEntrada = registroEstacionamentoService.registrarEntrada(inputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registroEntrada);
    }

    @PostMapping("/saida")
    public ResponseEntity<RegistroEstacionamentoDTO>registrarSaida(@RequestBody RegistroEstacionamentoInputDTO inputDto){
        RegistroEstacionamentoDTO registroSaida = registroEstacionamentoService.registrarSaida(inputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registroSaida);
    }

}
