package com.br.petshop.petshop.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ordemServicos")
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    @JsonBackReference
    private Cliente cliente;
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_animal", nullable = false)
    @JsonBackReference
    private Animal animal;
    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}