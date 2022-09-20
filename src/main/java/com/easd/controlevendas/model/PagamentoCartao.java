package com.easd.controlevendas.model;

import com.easd.controlevendas.model.enums.EstadoPagamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class PagamentoCartao extends Pagamento {

    private Integer numeroParcelas;

    public PagamentoCartao(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public PagamentoCartao(EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroParcelas) {
        super(estadoPagamento, pedido);
        this.numeroParcelas = numeroParcelas;
    }

    public PagamentoCartao() {

    }
}
