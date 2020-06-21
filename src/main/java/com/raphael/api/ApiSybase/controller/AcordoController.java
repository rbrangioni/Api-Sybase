package com.raphael.api.ApiSybase.controller;

import com.raphael.api.ApiSybase.domain.model.Acordo;
import com.raphael.api.ApiSybase.domain.model.Imovel;
import com.raphael.api.ApiSybase.error.ResourceNotFoundException;
import com.raphael.api.ApiSybase.repository.AcordoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/acordos")
public class AcordoController {

    @Autowired
    AcordoRepository acordoRepository;

    @GetMapping
    @ApiOperation(value = "Lista todos os acordos encontrados na base", response = Acordo.class)
    public List<Acordo> listar(){
        return acordoRepository.findAll();
    }

    @GetMapping("/{iAcordos}")
    @ApiOperation(value = "Retorna um acordo conforme Id informado")
    public ResponseEntity<Acordo> buscarCodigo(@PathVariable Integer iAcordos){
        Optional<Acordo> acordo = acordoRepository.findById(iAcordos);

        if(acordo.isPresent()){
            return ResponseEntity.ok(acordo.get());
        }
        verificaAcordoExistente(iAcordos);
        return ResponseEntity.notFound().build();
    }

    private void verificaAcordoExistente(Integer iAcordo){
        if(acordoRepository.findById(iAcordo).isEmpty())
            throw new ResourceNotFoundException("Acordo não Encontrado para o ID: "+ iAcordo);
    }
}
