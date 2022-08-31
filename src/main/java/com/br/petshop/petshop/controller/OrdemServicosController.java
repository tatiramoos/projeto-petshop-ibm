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

import com.br.petshop.petshop.dtos.OrdemServicoDto;
import com.br.petshop.petshop.models.OrdemServico;
import com.br.petshop.petshop.repository.IAnimalRepositorio;
import com.br.petshop.petshop.repository.IClienteRepositorio;
import com.br.petshop.petshop.repository.IOrdemServicoRepositorio;
import com.br.petshop.petshop.servicos.OrdemServicoService;

@RestController("/ordem-servicos")
public class OrdemServicosController {

    @Autowired
    private IAnimalRepositorio animalRepo;

    @Autowired
    private IClienteRepositorio clienteRepo;

    @Autowired
    private IOrdemServicoRepositorio ordemRepo;

    @GetMapping("")
    public Iterable<OrdemServico> index(){
        return ordemRepo.findAll();
    }

    @PostMapping("")
    public ResponseEntity<OrdemServico> create(@RequestBody OrdemServicoDto ordemServicoDto){
        var cliente = clienteRepo.findById(ordemServicoDto.getIdCliente());
        if(cliente.isEmpty()) return ResponseEntity.status(404).build();

        var animal = animalRepo.findById(ordemServicoDto.getIdAnimal());
        if(animal.isEmpty()) return ResponseEntity.status(404).build();
        
        var ordemServico = OrdemServicoService.persiste(new OrdemServico(), ordemServicoDto, cliente.get(), animal.get(), ordemRepo);
        
        return ResponseEntity.status(201).body(ordemServico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> show(@PathVariable int id){
        var ordem = ordemRepo.findById(id);
        return ResponseEntity.status(200).body(ordem.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> update(@PathVariable int id, @RequestBody OrdemServicoDto ordemServicoDto){
        var ordemDb = ordemRepo.findById(id);
        if(ordemDb.isEmpty()) return ResponseEntity.status(404).build();

        var cliente = clienteRepo.findById(ordemServicoDto.getIdCliente());
        if(cliente.isEmpty()) return ResponseEntity.status(404).build();
        
        var animal = animalRepo.findById(ordemServicoDto.getIdAnimal());
        if(animal.isEmpty()) return ResponseEntity.status(404).build();
        
        var ordem = OrdemServicoService.persiste(ordemDb.get(), ordemServicoDto, cliente.get(), animal.get(), ordemRepo);
        return ResponseEntity.status(200).body(ordem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrdemServico> delete(@PathVariable int id){
        animalRepo.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}