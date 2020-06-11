package com.raphael.api.ApiSybase.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "i_usuarios")
    private Integer iUsuario;

    @Column(name = "usr")
    private String user;

    private String nome;
    private String email;
    private String matricula;
    private String ativo;

    @OneToOne
    @JoinColumn(name = "i_pessoas")
    private Pessoa pessoa;

    public Integer getiUsuario() {
        return iUsuario;
    }

    public void setiUsuario(Integer iUsuario) {
        this.iUsuario = iUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return iUsuario.equals(usuario.iUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iUsuario);
    }
}
