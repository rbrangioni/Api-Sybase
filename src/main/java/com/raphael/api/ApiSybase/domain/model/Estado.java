package com.raphael.api.ApiSybase.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estados")
public class Estado {

    @Id
    @Column(name = "i_estados")
    private Integer iEstados;
    private String nome;
    private String sigla;

    public Estado() {
    }

    public Estado(Integer iEstados, String nome, String sigla) {
        this.iEstados = iEstados;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Integer getiEstados() {
        return iEstados;
    }

    public void setiEstados(Integer iEstados) {
        this.iEstados = iEstados;
    }

    public String getNome() {
        return nome.trim();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
