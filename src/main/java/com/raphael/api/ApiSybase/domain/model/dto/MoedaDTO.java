package com.raphael.api.ApiSybase.domain.model.dto;

import com.raphael.api.ApiSybase.domain.model.Moeda;

import java.io.Serializable;
import java.math.BigDecimal;

public class MoedaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iMoedas;
    private String nome;
    private String sigla;
    private String corrente;

    public MoedaDTO(Moeda moeda) {
        iMoedas=moeda.getiMoedas();
        nome=moeda.getNome();
        sigla=moeda.getSigla();
        corrente=moeda.getCorrente();

    }

    public Integer getiMoedas() {
        return iMoedas;
    }

    public void setiMoedas(Integer iMoedas) {
        this.iMoedas = iMoedas;
    }

    public String getNome() {
        return nome;
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
}
