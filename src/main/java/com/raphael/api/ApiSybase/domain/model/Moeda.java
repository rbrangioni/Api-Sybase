package com.raphael.api.ApiSybase.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "moedas")
public class Moeda  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_moedas")
    private Integer iMoedas;

    private String nome;
    private String sigla;
    private String corrente;

    @OneToMany(mappedBy = "moeda")
   // @JsonManagedReference
    private List<Indexador> indexador = new ArrayList<Indexador>();

    public Integer getiMoedas() {
        return iMoedas;
    }

    public void setiMoedas(Integer iMoedas) {
        this.iMoedas = iMoedas;
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

    public String getCorrente() {
        return corrente;
    }

    public void setCorrente(String corrente) {
        this.corrente = corrente;
    }

    public List<Indexador> getIndexador() {
        return indexador;
    }

    public void setIndexador(List<Indexador> indexador) {
        this.indexador = indexador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moeda moeda = (Moeda) o;
        return iMoedas.equals(moeda.iMoedas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iMoedas);
    }
}
