package br.com.estacionamento.service.exception;

public class EstabelecimentoNotFoundException extends RuntimeException {

    public EstabelecimentoNotFoundException(String msg) {
        super(msg);
    }
}
