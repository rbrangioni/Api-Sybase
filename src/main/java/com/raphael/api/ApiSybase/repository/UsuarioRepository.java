package com.raphael.api.ApiSybase.repository;

import com.raphael.api.ApiSybase.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByativo(String ativo);
}
