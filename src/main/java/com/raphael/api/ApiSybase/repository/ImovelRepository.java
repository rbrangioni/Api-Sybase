package com.raphael.api.ApiSybase.repository;

import com.raphael.api.ApiSybase.domain.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Integer> {
}
