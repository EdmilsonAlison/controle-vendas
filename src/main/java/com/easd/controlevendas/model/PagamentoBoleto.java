package com.easd.controlevendas.model;

import com.easd.controlevendas.model.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
public class PagamentoBoleto extends Pagamento {

    @JsonFormat(pattern = "dd/MM/yyyy ")
    private Date dataVencimento;
    @JsonFormat(pattern = "dd/MM/yyyy ")
    private Date dataPagamento;

    public PagamentoBoleto(Date dataVencimento, Date dataPagamento) {
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public PagamentoBoleto(EstadoPagamento estadoPagamento, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public PagamentoBoleto() {

    }
}
