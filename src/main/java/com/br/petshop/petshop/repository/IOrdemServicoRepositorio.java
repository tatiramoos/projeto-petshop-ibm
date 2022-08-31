package com.br.petshop.petshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.petshop.petshop.models.OrdemServico;

@Repository
public interface IOrdemServicoRepositorio extends CrudRepository<OrdemServico, Integer> {
    
}
