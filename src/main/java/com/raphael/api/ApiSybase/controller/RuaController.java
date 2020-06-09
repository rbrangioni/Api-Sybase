package com.raphael.api.ApiSybase.controller;

import com.raphael.api.ApiSybase.domain.model.Rua;
import com.raphael.api.ApiSybase.repository.RuaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ruas")
public class RuaController {

    @Autowired
    private RuaRepository ruaRepository;

    @GetMapping
    public List<Rua> listar(){
        return ruaRepository.findAll();
    }
}
