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

import com.br.petshop.petshop.dtos.AnimalDto;
import com.br.petshop.petshop.models.Animal;
import com.br.petshop.petshop.repository.IAnimalRepositorio;
import com.br.petshop.petshop.repository.IClienteRepositorio;
import com.br.petshop.petshop.servicos.AnimaisServico;

@RestController
public class AnimaisController {

    @Autowired
    private IAnimalRepositorio animalRepo;

    @Autowired
    private IClienteRepositorio clienteRepo;

    @GetMapping("/animais")
    public Iterable<Animal> index(){
        return animalRepo.findAll();
    }

    @PostMapping("/animais")
    public ResponseEntity<Animal> create(@RequestBody AnimalDto animalDto){
        var cliente = clienteRepo.findById(animalDto.getIdCliente());
       
        if(cliente.isEmpty()) return ResponseEntity.status(404).build();
        var animal = AnimaisServico.persiste(new Animal(), animalDto, cliente.get(), animalRepo);
        
        return ResponseEntity.status(201).body(animal);
    }

    @GetMapping("/animais/{id}")
    public ResponseEntity<Animal> show(@PathVariable int id){
        var animal = animalRepo.findById(id);
        return ResponseEntity.status(200).body(animal.get());
    }

    @PutMapping("/animais/{id}")
    public ResponseEntity<Animal> update(@PathVariable int id, @RequestBody AnimalDto animalDto){
        var animalDb = animalRepo.findById(id);
        if(animalDb.isEmpty()) return ResponseEntity.status(404).build();

        var cliente = clienteRepo.findById(animalDto.getIdCliente());
        if(cliente.isEmpty()) return ResponseEntity.status(404).build();

        var animal = AnimaisServico.persiste(animalDb.get(), animalDto, cliente.get(), animalRepo);
        return ResponseEntity.status(200).body(animal);
    }

    @DeleteMapping("/animais/{id}")
    public ResponseEntity<Animal> delete(@PathVariable int id){
        animalRepo.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}