package com.raphael.api.ApiSybase.repository;

import com.raphael.api.ApiSybase.domain.model.Cidade;
import com.raphael.api.ApiSybase.domain.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}

