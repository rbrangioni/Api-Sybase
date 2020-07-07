package com.raphael.api.ApiSybase.controller;

import com.raphael.api.ApiSybase.domain.model.Moeda;
import com.raphael.api.ApiSybase.domain.model.Pessoa;
import com.raphael.api.ApiSybase.domain.model.dto.MoedaDTO;
import com.raphael.api.ApiSybase.repository.MoedaRepository;
import com.raphael.api.ApiSybase.service.MoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/moedas")
public class MoedaController {

    @Autowired
    MoedaService moedaService;

    @GetMapping
    public ResponseEntity<List<MoedaDTO>> listarTodos(){

        List<Moeda> list = moedaService.listarTodos();
        List<MoedaDTO> dtoList = list.stream().map( obj -> new MoedaDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/{iMoeda}")
    public ResponseEntity<Moeda> buscarCodigo(@PathVariable Integer iMoeda){
        Moeda moeda = moedaService.buscarCodigo(iMoeda);

        return ResponseEntity.ok().body(moeda);
    }

}
