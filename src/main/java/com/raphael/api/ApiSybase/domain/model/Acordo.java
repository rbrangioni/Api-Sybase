package com.raphael.api.ApiSybase.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "acordos")
public class Acordo {
    @Id
    @Column(name = "i_acordos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iAcordos;

    @OneToOne
    @JoinColumn(name = "i_pessoas")
    private Pessoa pessoa;

    @Column(name = "data_acordo")
    @Temporal(TemporalType.DATE)
    private Date dataAcordo;

    @Column(name = "nr_parcela")
    private Integer numeroParcelas;

    private String comentario;

    @Column(name = "sit_acordo")
    private String situacaoAcordo;

    @OneToMany(mappedBy = "acordo")
    private List<AcordoParcela> acordoParcelas = new ArrayList<>();

    public Integer getiAcordos() {
        return iAcordos;
    }

    public void setiAcordos(Integer iAcordos) {
        this.iAcordos = iAcordos;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getDataAcordo() {
        return dataAcordo;
    }

    public void setDataAcordo(Date dataAcordo) {
        this.dataAcordo = dataAcordo;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getSituacaoAcordo() {

        String retornoSituacao="";

        switch (situacaoAcordo){
            case "A": retornoSituacao="Aberto";
                break;
            case "P": retornoSituacao="Em Pagamento";
                break;
            case "C": retornoSituacao="Cancelado";
                break;
            case "Q": retornoSituacao="Quitado";
                break;
            case "R": retornoSituacao="Remido";
                break;
        }
        return retornoSituacao;
    }

    public void setSituacaoAcordo(String situacaoAcordo) {
        this.situacaoAcordo = situacaoAcordo;
    }

    public List<AcordoParcela> getAcordoParcelas() {
        return acordoParcelas;
    }

    public void setAcordoParcelas(List<AcordoParcela> acordoParcelas) {
        this.acordoParcelas = acordoParcelas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acordo acordo = (Acordo) o;
        return iAcordos.equals(acordo.iAcordos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iAcordos);
    }
}
