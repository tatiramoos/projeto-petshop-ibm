package com.br.petshop.petshop.servicos;

import com.br.petshop.petshop.dtos.AnimalDto;
import com.br.petshop.petshop.models.Animal;
import com.br.petshop.petshop.models.Cliente;
import com.br.petshop.petshop.repository.IAnimalRepositorio;

public class AnimaisServico {
    public static Animal persiste(Animal animal, AnimalDto animalDto, Cliente cliente, IAnimalRepositorio animalRepo){
        animal.setNome(animalDto.getNome());
        animal.setIdade(animalDto.getIdade());
        animal.setPeso(animalDto.getPeso());
        animal.setCliente(cliente);
        animalRepo.save(animal);
        return animal;
    }
}
