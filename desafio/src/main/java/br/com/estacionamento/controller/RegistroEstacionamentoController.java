package br.com.estacionamento.controller;

import br.com.estacionamento.dtos.request.RegistroEstacionamentoRequestDTO;
import br.com.estacionamento.dtos.response.RegistroEstacionamentoResponseDTO;
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
    public ResponseEntity<RegistroEstacionamentoResponseDTO> registrarEntrada(@RequestBody RegistroEstacionamentoRequestDTO dto){
        RegistroEstacionamentoResponseDTO registroEntrada = registroEstacionamentoService.registrarEntrada(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registroEntrada);
    }

    @PostMapping("/saida")
    public ResponseEntity<RegistroEstacionamentoResponseDTO> registrarSaida(@RequestBody RegistroEstacionamentoRequestDTO dto){
        RegistroEstacionamentoResponseDTO registroSaida = registroEstacionamentoService.registrarSaida(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registroSaida);
    }

}
