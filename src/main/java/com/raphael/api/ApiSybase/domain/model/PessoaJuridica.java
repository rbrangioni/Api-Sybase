package com.raphael.api.ApiSybase.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "pessoas_juridicas")
public class PessoaJuridica {

    @Id
    @Column(name = "i_pessoas")
    private Integer iPessoas;

    private String cnpj;

    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;

    public Integer getiPessoas() {
        return iPessoas;
    }

    public void setiPessoas(Integer iPessoas) {
        this.iPessoas = iPessoas;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaJuridica that = (PessoaJuridica) o;
        return iPessoas.equals(that.iPessoas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iPessoas);
    }
}
