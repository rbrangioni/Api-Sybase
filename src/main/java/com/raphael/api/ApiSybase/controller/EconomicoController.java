package com.raphael.api.ApiSybase.controller;

import com.raphael.api.ApiSybase.domain.model.Economico;
import com.raphael.api.ApiSybase.domain.model.Pessoa;
import com.raphael.api.ApiSybase.domain.model.Usuario;
import com.raphael.api.ApiSybase.repository.EconomicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/economicos")
public class EconomicoController {

    @Autowired
    private EconomicoRepository economicoRepository;

    @GetMapping
    public List<Economico> listar(){
        return economicoRepository.findAll();
    }

    @GetMapping("/{iEconomicos}")
    public ResponseEntity<Economico> buscarCodigo(@PathVariable Integer iEconomicos){
        Optional<Economico> economico = economicoRepository.findById(iEconomicos);

        if(economico.isPresent()){
            return ResponseEntity.ok(economico.get());
        }
        return ResponseEntity.notFound().build();
    }
}
