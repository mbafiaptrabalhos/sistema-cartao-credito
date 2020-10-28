package com.fiap.microservice.extrato.dto;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ExtratoDTO {

	@Id
	private String id;
	private String email;
	private String rmAluno;
	private String descricao;
	private String data;
	private BigDecimal valorCompra;
	
	public ExtratoDTO(String id, 
			String email,
			String rmAluno,
			String descricao,
			String data,
			BigDecimal valorCompra) {
        this.id = id;
        this.email = email;
        this.rmAluno = rmAluno;
        this.descricao = descricao;
        this.data = data;
        this.valorCompra = valorCompra;
    }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
