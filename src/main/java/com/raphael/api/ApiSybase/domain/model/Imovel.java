package com.raphael.api.ApiSybase.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "imoveis")
public class Imovel {

    @Id
    @Column(name = "i_imoveis")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iImoveis;
    private Integer dv;

    @OneToOne
    @JoinColumn(name = "i_pessoas")
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "i_ruas")
    private Rua rua;

    private String numero;

    @Column(name = "engloba_com")
    private Integer englobaCom;

    private String lote;
    private String quadra;
    private String matricula;

    public Integer getiImoveis() {
        return iImoveis;
    }

    public void setiImoveis(Integer iImoveis) {
        this.iImoveis = iImoveis;
    }

    public Integer getDv() {
        return dv;
    }

    public void setDv(Integer dv) {
        this.dv = dv;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Rua getRua() {
        return rua;
    }

    public void setRua(Rua rua) {
        this.rua = rua;
    }

    public String getNumero() {
        if(numero == null){
            return "SN";
        }
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getEnglobaCom() {
        return englobaCom;
    }

    public void setEnglobaCom(Integer englobaCom) {
        this.englobaCom = englobaCom;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getQuadra() {
        return quadra;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imovel imovel = (Imovel) o;
        return iImoveis.equals(imovel.iImoveis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iImoveis);
    }
}
