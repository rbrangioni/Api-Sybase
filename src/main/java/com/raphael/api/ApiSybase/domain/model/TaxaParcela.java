package com.raphael.api.ApiSybase.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "taxas_parcelas")
public class TaxaParcela {

    @Id
    @Column(name = "num_parc")
    private Integer numeroParcela;

    @Column(name = "valor_taxa",  scale = 15, precision = 4)
    private BigDecimal valorTaxa;


    public BigDecimal getValorTaxa() {
        return valorTaxa;
    }

    public void setValorTaxa(BigDecimal valorTaxa) {
        this.valorTaxa = valorTaxa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxaParcela that = (TaxaParcela) o;
        return numeroParcela.equals(that.numeroParcela);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroParcela);
    }
}
