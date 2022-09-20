package com.easd.controlevendas.dto;

import com.easd.controlevendas.model.Endereco;
import com.easd.controlevendas.model.Pedido;
import com.easd.controlevendas.model.enums.TipoCliente;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ClienteDto {

    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private TipoCliente tipoCliente;
    private List<Endereco> enderecos = new ArrayList<>();
    private Set<String> telefones = new HashSet<>();
    private List<Pedido> pedidos =  new ArrayList<>();
}
