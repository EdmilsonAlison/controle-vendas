package com.easd.controlevendas.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Embeddable
public class ItemPedidoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @EqualsAndHashCode.Include
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @EqualsAndHashCode.Include
    private Produto produto;
}
