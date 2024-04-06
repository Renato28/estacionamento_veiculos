package br.com.estacionamento.model;

public enum Tipo {

    MOTO("MOTO"),
    CARRO("CARRO");

    private String tipo;

    Tipo(String tipo) {
        this.tipo = tipo;
    }
}
