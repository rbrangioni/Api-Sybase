package com.raphael.api.ApiSybase.controller;

import com.raphael.api.ApiSybase.domain.model.Pessoa;
import com.raphael.api.ApiSybase.domain.model.Usuario;
import com.raphael.api.ApiSybase.repository.UsuarioRepository;
import com.raphael.api.ApiSybase.service.ExecuteScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private ExecuteScript executeScript;

    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{iUsuario}")
    public ResponseEntity<Usuario> buscarCodigo(@PathVariable Integer iUsuario){
        Optional<Usuario> usuario = usuarioRepository.findById(iUsuario);

        if(usuario.isPresent()){
            return ResponseEntity.ok(usuario.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{iUsuario}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Integer iUsuario, @RequestBody Usuario usuario){
        if(!usuarioRepository.existsById(iUsuario)){
            return ResponseEntity.notFound().build();
        }
        executeScript.execute("call bethadba.dbp_conn_gera(1,2020,301);  ");
        usuario.setiUsuario(iUsuario);
        usuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }
}
