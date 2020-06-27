package com.raphael.api.ApiSybase.controller;

import com.raphael.api.ApiSybase.domain.model.Pessoa;
import com.raphael.api.ApiSybase.domain.model.Rua;
import com.raphael.api.ApiSybase.domain.model.Usuario;
import com.raphael.api.ApiSybase.error.ResourceNotFoundException;
import com.raphael.api.ApiSybase.repository.RuaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ruas")
public class RuaController {

    @Autowired
    private RuaRepository ruaRepository;

    @GetMapping
    public List<Rua> listar(){
        return ruaRepository.findAll();
    }

    @GetMapping("/{iRuas}")
    public ResponseEntity<Rua> buscarCodigo(@PathVariable Integer iRuas){
        Optional<Rua> rua = ruaRepository.findById(iRuas);

        if(rua.isPresent()){
            return ResponseEntity.ok(rua.get());
        }
        verificaRuaExistente(iRuas);
        return ResponseEntity.notFound().build();
    }

    private void verificaRuaExistente(Integer iRua){
        if(ruaRepository.findById(iRua).isEmpty())
            throw new ResourceNotFoundException("Rua não Encontrada para o ID: "+ iRua);
    }
}
