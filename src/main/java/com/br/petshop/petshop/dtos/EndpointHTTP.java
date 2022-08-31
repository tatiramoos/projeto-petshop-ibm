package com.br.petshop.petshop.dtos;

public class EndpointHTTP {
    public EndpointHTTP(String method, String path, String descricao){
        this.method = method;
        this.path = path;
        this.descricao = descricao;
    }
    
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    private String method;
    public String getMethod() {
        return method;
    }

    private String path;
    public String getPath() {
        return path;
    }
}