package com.raphael.api.ApiSybase.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ruas")
public class Rua {

    @Id
    @Column(name = "i_ruas")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iRuas;
    private String nome;

    @Column(name = "i_cidades")
    private Integer iCidades;

    private String cep;

    public Integer getiRuas() {
        return iRuas;
    }

    public void setiRuas(Integer iRuas) {
        this.iRuas = iRuas;
    }

    public String getNome() {
        return nome.trim();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getiCidades() {
        return iCidades;
    }

    public void setiCidades(Integer iCidades) {
        this.iCidades = iCidades;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rua rua = (Rua) o;
        return iRuas.equals(rua.iRuas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iRuas);
    }
}
