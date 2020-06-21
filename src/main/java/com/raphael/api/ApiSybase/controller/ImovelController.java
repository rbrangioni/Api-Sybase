package com.raphael.api.ApiSybase.controller;

import com.raphael.api.ApiSybase.domain.model.Imovel;
import com.raphael.api.ApiSybase.domain.model.Pessoa;
import com.raphael.api.ApiSybase.error.ResourceNotFoundException;
import com.raphael.api.ApiSybase.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/imoveis")
public class ImovelController {

    @Autowired
    ImovelRepository imovelRepository;

    @GetMapping
    public List<Imovel> listar(){
        return imovelRepository.findAll();
    }

    @GetMapping("/{iImoveis}")
    public ResponseEntity<Imovel> buscarCodigo(@PathVariable Integer iImoveis){
        Optional<Imovel> imovel = imovelRepository.findById(iImoveis);

        if(imovel.isPresent()){
            return ResponseEntity.ok(imovel.get());
        }
        verificaImovelExistente(iImoveis);
        return ResponseEntity.notFound().build();
    }

    private void verificaImovelExistente(Integer iImovel){
        if(imovelRepository.findById(iImovel).isEmpty())
            throw new ResourceNotFoundException("Imóvel não Encontrado para o ID: "+ iImovel);
    }

}
