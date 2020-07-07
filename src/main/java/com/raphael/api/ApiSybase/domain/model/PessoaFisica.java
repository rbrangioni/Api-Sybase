package com.raphael.api.ApiSybase.domain.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pessoas_fisicas")
public class PessoaFisica implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "i_pessoas")
    private Integer iPessoasFisicas;
    private String cpf;
    private String rg;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento")
    private Date dataNascimento;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getiPessoasFisicas() {
        return iPessoasFisicas;
    }

    public void setiPessoasFisicas(Integer iPessoasFisicas) {
        this.iPessoasFisicas = iPessoasFisicas;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {

        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {

        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaFisica that = (PessoaFisica) o;
        return Objects.equals(iPessoasFisicas, that.iPessoasFisicas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iPessoasFisicas);
    }
}
