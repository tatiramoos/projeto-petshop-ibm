package com.br.petshop.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.petshop.petshop.models.Cliente;
import com.br.petshop.petshop.repository.IClienteRepositorio;

@RestController
public class ClientesController {

    @Autowired
    private IClienteRepositorio clienteRepo;

    @GetMapping("/clientes")
    public Iterable<Cliente> index(){
        return clienteRepo.findAll();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        clienteRepo.save(cliente);
        return ResponseEntity.status(201).body(cliente);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> show(@PathVariable int id){
        var cliente = clienteRepo.findById(id);
        return ResponseEntity.status(200).body(cliente.get());
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> update(@PathVariable int id, @RequestBody Cliente cliente){
        var clienteDb = clienteRepo.findById(id);
        if(clienteDb.isEmpty()) return ResponseEntity.status(404).build();
        var clienteInstance = clienteDb.get();
        clienteInstance.setNome(cliente.getNome());
        clienteInstance.setTelefone(cliente.getTelefone());
        clienteRepo.save(clienteInstance);
        return ResponseEntity.status(200).body(clienteInstance);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable int id){
        clienteRepo.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}