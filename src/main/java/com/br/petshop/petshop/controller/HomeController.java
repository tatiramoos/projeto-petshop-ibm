package com.br.petshop.petshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.petshop.petshop.dtos.HomeDto;

@RestController
public class HomeController {
    @GetMapping("/")
    public HomeDto index(){
        return new HomeDto();
    }
}