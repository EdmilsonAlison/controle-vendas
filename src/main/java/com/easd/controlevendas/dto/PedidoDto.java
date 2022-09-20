package com.easd.controlevendas.dto;

import com.easd.controlevendas.model.Cliente;
import com.easd.controlevendas.model.Endereco;
import com.easd.controlevendas.model.ItemPedido;
import com.easd.controlevendas.model.Pagamento;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PedidoDto {

    private Integer id;
    private Date instante;
    private Pagamento pagamento;
    private Cliente cliente;
    private Endereco enderecoEntrega;
    private Set<ItemPedido> itens = new HashSet<>();
}
