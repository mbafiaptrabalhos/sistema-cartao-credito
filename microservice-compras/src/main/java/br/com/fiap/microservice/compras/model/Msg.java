package br.com.fiap.microservice.compras.model;

import java.io.Serializable;

public class Msg implements Serializable {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
