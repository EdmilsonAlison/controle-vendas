package com.easd.controlevendas.model.enums;

import lombok.Getter;

@Getter
public enum TipoCliente {

    PESSOAFISICA(1,"Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private Integer code;
    private String descricao;

    TipoCliente(Integer code, String descricao) {
        this.code = code;
        this.descricao = descricao;
    }

    public static TipoCliente toEnum(Integer code){
        if(code == null){
            return null;
        }

        for (TipoCliente x : TipoCliente.values()) {
            if(code.equals(x.getCode())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido");
    }
}
