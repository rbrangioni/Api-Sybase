package com.raphael.api.ApiSybase.repository;

import com.raphael.api.ApiSybase.domain.model.Economico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomicoRepository extends JpaRepository<Economico, Integer> {
}
