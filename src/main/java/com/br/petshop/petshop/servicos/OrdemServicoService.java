package com.br.petshop.petshop.servicos;

import com.br.petshop.petshop.dtos.OrdemServicoDto;
import com.br.petshop.petshop.models.Animal;
import com.br.petshop.petshop.models.Cliente;
import com.br.petshop.petshop.models.OrdemServico;
import com.br.petshop.petshop.repository.IOrdemServicoRepositorio;

public class OrdemServicoService {
    public static OrdemServico persiste(OrdemServico ordemServico, OrdemServicoDto ordemServicoDto, Cliente cliente, Animal animal, IOrdemServicoRepositorio ordemServicoRepo){
        ordemServico.setValor(ordemServicoDto.getValor());
        ordemServico.setEntrada(ordemServicoDto.getEntrada());
        ordemServico.setSaida(ordemServicoDto.getSaida());
        ordemServico.setAnimal(animal);
        ordemServico.setCliente(cliente);
        ordemServicoRepo.save(ordemServico);
        return ordemServico;
    }
}