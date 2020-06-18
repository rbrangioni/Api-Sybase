package com.raphael.api.ApiSybase.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "economicos")
public class Economico {
    @Id
    @Column(name = "i_economicos")
    private Integer iEconomicos;

    @OneToOne
    @JoinColumn(name = "i_pessoas")
    private Pessoa pessoa;

    private String tipo;
    private String principal;

   @Column(name = "i_contadores")
   private Integer iConatador;



    public Economico() {
    }

    public Economico(Integer iEconomicos, Pessoa pessoa, String tipo, String principal, Integer iConatador) {
        this.iEconomicos = iEconomicos;
        this.pessoa = pessoa;
        this.tipo = tipo;
        this.principal = principal;
    }

    public Integer getiEconomicos() {
        return iEconomicos;
    }

    public void setiEconomicos(Integer iEconomicos) {
        this.iEconomicos = iEconomicos;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Integer getiConatador() {
        return iConatador;
    }

    public void setiConatador(Integer iConatador) {
        this.iConatador = iConatador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Economico economico = (Economico) o;
        return iEconomicos.equals(economico.iEconomicos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iEconomicos);
    }
}
