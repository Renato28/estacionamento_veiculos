package br.com.estacionamento.service.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StandardError {
    
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;
}




