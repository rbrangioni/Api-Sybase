package com.raphael.api.ApiSybase.service;

import com.raphael.api.ApiSybase.domain.model.Moeda;
import com.raphael.api.ApiSybase.domain.model.dto.MoedaDTO;
import com.raphael.api.ApiSybase.repository.MoedaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class MoedaService {

    @Autowired
    private MoedaRepository moedaRepository;

    @GetMapping
    public List<Moeda> listarTodos(){
        return moedaRepository.findAll();
    }

    @GetMapping("/{iMoeda}")
    public Moeda buscarCodigo(@PathVariable Integer iMoeda){
        Optional<Moeda> moeda = moedaRepository.findById(iMoeda);

            return moeda.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Moeda adicionar(@RequestBody Moeda moeda) {
        return moedaRepository.save(moeda);

    }
}
