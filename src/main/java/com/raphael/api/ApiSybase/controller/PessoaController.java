package com.raphael.api.ApiSybase.controller;

import com.raphael.api.ApiSybase.domain.model.Pessoa;
import com.raphael.api.ApiSybase.repository.PessoaRepository;
import com.raphael.api.ApiSybase.service.ExecuteScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ExecuteScript executeScript;

    @GetMapping
    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    @GetMapping("/busca/{nome}")
    public List<Pessoa> listarPorNome(@PathVariable String nome){
        return pessoaRepository.findByNomeContaining(nome);
    }

    @GetMapping("/{iPessoas}")
    public ResponseEntity<Pessoa> buscarCodigo(@PathVariable Integer iPessoas){
        Optional<Pessoa> pessoa = pessoaRepository.findById(iPessoas);

        if(pessoa.isPresent()){
            return ResponseEntity.ok(pessoa.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{iPessoa}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Integer iPessoa, @RequestBody Pessoa pessoa){
        if(!pessoaRepository.existsById(iPessoa)){
            return ResponseEntity.notFound().build();
        }
        executeScript.execute("call bethadba.dbp_conn_gera(1,2019,301);  ");
        pessoa.setiPessoas(iPessoa);
        pessoa = pessoaRepository.save(pessoa);
        return ResponseEntity.ok(pessoa);
  }


}
