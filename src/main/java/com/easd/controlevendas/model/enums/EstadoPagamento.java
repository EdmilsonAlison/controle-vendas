package com.easd.controlevendas.model.enums;

import lombok.Getter;

@Getter
public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),QUITADO(2,"Quitado"),CANCELADO(3,"Cancelado");



    private Integer code;
    private String descricao;

    EstadoPagamento(Integer code, String descricao) {
        this.code = code;
        this.descricao = descricao;
    }

    public static EstadoPagamento toEnum(Integer code){
        if(code == null){
            return null;
        }

        for (EstadoPagamento x : EstadoPagamento.values()) {
            if(code.equals(x.getCode())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido");
    }
}
