package com.raphael.api.ApiSybase.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pessoas")
public class Pessoa {

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

    @JoinColumn(name = "i_pessoas")
    @OneToOne
    private PessoaFisica pessoaFisica;

    @JoinColumn(name = "i_pessoas")
    @OneToOne
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
