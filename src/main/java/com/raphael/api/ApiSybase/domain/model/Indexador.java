package com.raphael.api.ApiSybase.domain.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "indexadores")
public class Indexador  implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "i_moedas")
    private Moeda moeda;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "data_idx")
    private Date dataIndexador;

    @Column(name = "valor_idx")
    private BigDecimal valorIndexador;

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }

    public Date getDataIndexador() {
        return dataIndexador;
    }

    public void setDataIndexador(Date dataIndexador) {
        this.dataIndexador = dataIndexador;
    }

    public BigDecimal getValorIndexador() {
        return valorIndexador;
    }

    public void setValorIndexador(BigDecimal valorIndexador) {
        this.valorIndexador = valorIndexador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indexador indexador = (Indexador) o;
        return moeda.equals(indexador.moeda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moeda);
    }
}
