package br.com.estacionamento.service.exception.exceptionHandlers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.estacionamento.service.exception.StandardError;
import br.com.estacionamento.service.exception.VeiculoNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    
     

   @ExceptionHandler(VeiculoNotFoundException.class)
   public ResponseEntity<StandardError>veiculoNotFoundException(VeiculoNotFoundException ex , HttpServletRequest request){

    StandardError error = 
             new StandardError(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),ex.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    
   }
}
