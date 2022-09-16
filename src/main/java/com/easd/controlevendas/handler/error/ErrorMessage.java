package com.easd.controlevendas.handler.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    private String titulo;
    private String mensagem;
    private Integer status;

    public ErrorMessage(String titulo, String mensagem, Integer status) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.status = status;
    }

}
