package com.raphael.api.ApiSybase.controller;

import com.raphael.api.ApiSybase.domain.model.Cidade;
import com.raphael.api.ApiSybase.domain.model.Estado;
import com.raphael.api.ApiSybase.domain.model.Rua;
import com.raphael.api.ApiSybase.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;


    @GetMapping
    public List<Cidade> listar(){
        return cidadeRepository.findAll();
    }


}
