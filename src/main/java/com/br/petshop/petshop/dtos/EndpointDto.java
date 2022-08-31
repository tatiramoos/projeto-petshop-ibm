package com.br.petshop.petshop.dtos;

import java.util.List;

public class EndpointDto {
    public EndpointDto(String nome, List<EndpointHTTP> endpointHTTP){
        this.nome = nome;
        this.endpointHTTP = endpointHTTP;
    }

    private String nome;
    public String getNome() {
        return nome;
    }

    private List<EndpointHTTP> endpointHTTP;
    public List<EndpointHTTP> getEndpointHTTP() {
        return endpointHTTP;
    }
}