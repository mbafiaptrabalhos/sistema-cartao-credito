package br.com.fiao.microservice.autorizadora.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Compra {

	@Id
	private String rmAluno;
    private BigDecimal valorCompra;
    private String descricao;
    private String data;
 
    public Compra() {}

	public String getRmAluno() {
		return rmAluno;
	}

	public void setRmAluno(String rmAluno) {
		this.rmAluno = rmAluno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
    
}