package com.raphael.api.ApiSybase.controller;

import com.raphael.api.ApiSybase.domain.model.Moeda;
import com.raphael.api.ApiSybase.domain.model.Pessoa;
import com.raphael.api.ApiSybase.repository.MoedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/moedas")
public class MoedaController {

    @Autowired
    MoedaRepository moedaRepository;

    @GetMapping
    public List<Moeda> listar(){
        return moedaRepository.findAll();
    }

    @GetMapping("/{iMoeda}")
    public ResponseEntity<Moeda> buscarCodigo(@PathVariable Integer iMoeda){
        Optional<Moeda> moeda = moedaRepository.findById(iMoeda);

        if(moeda.isPresent()){
            return ResponseEntity.ok(moeda.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Moeda adicionar(@RequestBody Moeda moeda) {
        return moedaRepository.save(moeda);

    }
}
