package com.raphael.api.ApiSybase.repository;

import com.raphael.api.ApiSybase.domain.model.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoedaRepository extends JpaRepository<Moeda, Integer> {
}
