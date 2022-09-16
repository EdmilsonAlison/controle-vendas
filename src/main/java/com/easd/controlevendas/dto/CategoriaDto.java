package com.easd.controlevendas.dto;

import com.easd.controlevendas.model.Produto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoriaDto {

    private Integer id;
    private String nome;
    private List<Produto> produtos = new ArrayList<>();
}
