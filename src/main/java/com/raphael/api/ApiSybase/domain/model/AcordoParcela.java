package com.raphael.api.ApiSybase.domain.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

@Entity
@Table(name = "acordos_parcelas")
public class AcordoParcela {
    @Id
    @Column(name = "num_parc")
    private Integer numeroParcela;

    @ManyToOne
    @JoinColumn(name = "i_acordos")
    private Acordo acordo;

    private Integer parcela;

    @Column(name = "data_vcto")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    private String flag;

    @Column(name = "valor_tributo", scale = 15, precision = 4)
    private BigDecimal ValorTributo;

    @Column(name = "valor_correcao",  scale = 15, precision = 4)
    private BigDecimal ValorCorrecao;

    @Column(name = "valor_juro",  scale = 15, precision = 4)
    private BigDecimal ValorJuro;

    @Column(name = "valor_multa",  scale = 15, precision = 4)
    private BigDecimal valorMulta;

    @OneToOne
    @JoinColumn(name = "num_parc")
    private TaxaParcela taxaParcela;

    @Transient
    private BigDecimal valorParcela;


    public Integer getNumeroParcela() {
        return numeroParcela;
    }


    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getFlag() {
        String retornoFlag = "";
        switch (flag) {
            case "A":
                retornoFlag = "Aberta";
                break;
            case "P":
                retornoFlag = "Paga";
                break;
            case "C":
                retornoFlag = "Cancelada";
                break;
            case "E":
                retornoFlag = "Excluída";
                break;
            case "S":
                retornoFlag = "Suspensa";
                break;
            case "D":
                retornoFlag = "Cancelada Manutenção de Parcelamento";
                break;
            case "R":
                retornoFlag = "Remida";
                break;
        }
        return retornoFlag;
    }


    public void setFlag(String flag) {
        this.flag = flag;
    }

    public BigDecimal getValorParcela() {
        valorParcela = ValorTributo.add(ValorCorrecao).add(ValorJuro).add(valorMulta);
        return valorParcela;
    }

    public TaxaParcela getTaxaParcela() {
        return taxaParcela;
    }

    public void setTaxaParcela(TaxaParcela taxaParcela) {
        this.taxaParcela = taxaParcela;
    }
}
