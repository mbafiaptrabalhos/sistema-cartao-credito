package com.fiap.microservice.extrato.model;

import com.fiap.microservice.extrato.dto.ExtratoDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class Compra {

	@Id
	private String rmAluno;
	private String id;
	private String email;
	private String descricao;
	private String data;
	private BigDecimal valorCompra;
	
	public Compra(ExtratoDTO extratoDTO) {
		this.id = extratoDTO.getId();
		this.email = extratoDTO.getEmail();
		this.rmAluno = extratoDTO.getRmAluno();
		this.descricao = extratoDTO.getDescricao();
		this.data = LocalDateTime.now().toString();
	}
	
	public Compra() {
		
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	
}
