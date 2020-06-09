package com.raphael.api.ApiSybase.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cidades")
public class Cidade {

    @Id
    @Column(name = "i_cidades")
    private Integer iCidades;
    private String nome;

    @Column(name = "cod_siafi")
    private Integer codigoSiafi;

    @JoinColumn(name = "i_estados")
    @OneToOne
    private Estado estado;


    public Cidade() {
    }

    public Cidade(Integer iCidades, String nome, Integer codigoSiafi, Estado estado) {
        this.iCidades = iCidades;
        this.nome = nome;
        this.codigoSiafi = codigoSiafi;
        this.estado = estado;
    }

    public Integer getiCidades() {
        return iCidades;
    }

    public void setiCidades(Integer iCidades) {
        this.iCidades = iCidades;
    }

    public String getNome() {
        return nome.trim();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigoSiafi() {
        return codigoSiafi;
    }

    public void setCodigoSiafi(Integer codigoSiafi) {
        this.codigoSiafi = codigoSiafi;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return iCidades.equals(cidade.iCidades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iCidades);
    }
}
