package com.raphael.api.ApiSybase.domain.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_pessoas")
    private Integer iPessoas;
    private Integer dv;
    private String nome;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "tipo_pessoa")
    private String tipoPessoa;
    private String email;

    @Column(name = "ddd_cel")
    private String dddCelular;
    private String celular;

    @JoinColumn(name = "i_pessoas")
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @NotFound(action = NotFoundAction.IGNORE)
    private PessoaFisica pessoaFisica;

    @JoinColumn(name = "i_pessoas")
    @OneToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private PessoaJuridica pessoaJuridica;




    public Integer getiPessoas() {
        return iPessoas;
    }

    public void setiPessoas(Integer iPessoas) {
        this.iPessoas = iPessoas;
    }

    public Integer getDv() {
        return dv;
    }

    public void setDv(Integer dv) {
        this.dv = dv;
    }

    public String getNome() {
        return nome.trim();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(String dddCelular) {
        this.dddCelular = dddCelular;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return iPessoas.equals(pessoa.iPessoas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iPessoas);
    }
}
