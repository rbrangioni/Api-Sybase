package com.raphael.api.ApiSybase.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "indexadores")
public class Indexador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "data_idx")
    private OffsetDateTime dataIndexador;

    @Column(name = "valor_idx")
    private BigDecimal valorIndexador;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "i_moedas")
    private Moeda moeda;

    public OffsetDateTime getDataIndexador() {
        return dataIndexador;
    }

    public void setDataIndexador(OffsetDateTime dataIndexador) {
        this.dataIndexador = dataIndexador;
    }

    public BigDecimal getValorIndexador() {
        return valorIndexador;
    }

    public void setValorIndexador(BigDecimal valorIndexador) {
        this.valorIndexador = valorIndexador;
    }

//    public Moeda getMoeda() {
//        return moeda;
//    }
//
//    public void setMoeda(Moeda moeda) {
//        this.moeda = moeda;
//    }


}
