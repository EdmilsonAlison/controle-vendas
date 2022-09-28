package com.easd.controlevendas.dto;

import com.easd.controlevendas.model.Categoria;
import com.easd.controlevendas.model.Produto;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoriaDto {

    private Integer id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 80, message = "O tamanho min 5 e max 80")
    private String nome;
    private List<Produto> produtos = new ArrayList<>();

    public CategoriaDto() {
    }

    public CategoriaDto(Categoria cat) {
        this.id = cat.getId();
        this.nome = cat.getNome();
        this.produtos = cat.getProdutos();
    }
}
