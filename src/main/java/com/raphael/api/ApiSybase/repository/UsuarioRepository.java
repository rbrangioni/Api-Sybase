package com.raphael.api.ApiSybase.repository;

import com.raphael.api.ApiSybase.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
