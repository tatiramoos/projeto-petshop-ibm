package com.br.petshop.petshop.dtos;

import java.util.ArrayList;
import java.util.List;

public class HomeDto {
    public List<EndpointDto> getEndpoints(){
        var list = new ArrayList<EndpointDto>();
        var methodsClientes = new ArrayList<EndpointHTTP>();
        methodsClientes.add(new EndpointHTTP("GET", "clientes",  "Retorna todos os clientes"));
        methodsClientes.add(new EndpointHTTP("POST", "clientes", "cadastra um cliente"));
        methodsClientes.add(new EndpointHTTP("PUT", "clientes/:id", "atualiza um cliente"));
        methodsClientes.add(new EndpointHTTP("GET", "clientes/:id", "retorna somente um cliente"));
        methodsClientes.add(new EndpointHTTP("DELETE", "clientes/:id",  "apago um cliente"));

        var clientesEnd = new EndpointDto("clientes", methodsClientes);
        list.add(clientesEnd);

        return list;
    }
}