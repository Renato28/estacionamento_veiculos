package br.com.estacionamento.service.exception;

public class VeiculoNotFoundException  extends RuntimeException {

    public VeiculoNotFoundException(String msg) {
        super(msg);
    }
}
