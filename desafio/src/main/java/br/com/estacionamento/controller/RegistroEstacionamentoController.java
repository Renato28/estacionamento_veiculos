package br.com.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.model.RegistroEstacionamento;
import br.com.estacionamento.service.RegistroEstacionamentoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/registro/estacionamento")
public class RegistroEstacionamentoController {

    @Autowired
    private  RegistroEstacionamentoService registroEstacionamentoService;

    @PostMapping("/entrada")
    public ResponseEntity<RegistroEstacionamento>registrarEntrada(@RequestBody RegistroEstacionamento registroEstacionamento){

       
        RegistroEstacionamento registro = registroEstacionamentoService.registrarEntrada(registroEstacionamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(registro);

    }


    @PostMapping("/saida")
    public ResponseEntity<RegistroEstacionamento>registrarSaida(@RequestBody RegistroEstacionamento registroEstacionamento){

       
        RegistroEstacionamento registro = registroEstacionamentoService.registrarSaida(registroEstacionamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(registro);

    }


}
