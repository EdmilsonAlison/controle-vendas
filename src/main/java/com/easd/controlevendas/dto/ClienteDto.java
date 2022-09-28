package com.easd.controlevendas.dto;

import com.easd.controlevendas.model.Cliente;
import com.easd.controlevendas.model.Endereco;
import com.easd.controlevendas.model.Pedido;
import com.easd.controlevendas.model.enums.TipoCliente;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.domain.Page;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter

public class ClienteDto {

    private Integer id;
    @NotEmpty(message = "Preenchimento necessário")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 a 120 caracteres")
    private String nome;
    @NotEmpty(message = "Preenchimento necessário")
    @Email(message = "Email inválido")
    private String email;
    @CPF
    private String cpfOuCnpj;
    private TipoCliente tipoCliente;
    private List<Endereco> enderecos = new ArrayList<>();
    private Set<String> telefones = new HashSet<>();
    private List<Pedido> pedidos =  new ArrayList<>();
}
