package br.com.fiap.microservice.compras.model;

import br.com.fiap.microservice.compras.dto.CompraDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Compra {

    private String rmAluno;
    private BigDecimal valorCompra;
    private String descricao;
    private String data;

    public Compra(CompraDTO compraDTO) {
        this.rmAluno = compraDTO.getRmAluno();
        this.valorCompra = compraDTO.getValorCompra();
        this.descricao = compraDTO.getDescricao();
        this.data = LocalDateTime.now().toString();
    }

    public Compra() {
    }

    public String getRmAluno() {
        return rmAluno;
    }

    public void setRmAluno(String rmAluno) {
        this.rmAluno = rmAluno;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
