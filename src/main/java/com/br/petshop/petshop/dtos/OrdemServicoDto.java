package com.br.petshop.petshop.dtos;

import java.time.LocalDateTime;

public class OrdemServicoDto {
    private float valor;
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    private LocalDateTime entrada;
    public LocalDateTime getEntrada() {
        return entrada;
    }
    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    private LocalDateTime saida;
    public LocalDateTime getSaida() {
        return saida;
    }
    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    private int idCliente;
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    private int idAnimal;
    public int getIdAnimal() {
        return idAnimal;
    }
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
}