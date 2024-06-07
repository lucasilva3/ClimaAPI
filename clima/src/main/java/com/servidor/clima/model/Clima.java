package com.servidor.clima.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "registros_climaticos")
public class Clima {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cidade;
	private BigDecimal temperatura;
	private BigDecimal umidade;
	private String descricao;
	private Timestamp data_hora;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public BigDecimal getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(BigDecimal temperatura) {
		this.temperatura = temperatura;
	}
	public BigDecimal getUmidade() {
		return umidade;
	}
	public void setUmidade(BigDecimal umidade) {
		this.umidade = umidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@PrePersist
    public void prePersist() {
        data_hora = new Timestamp(System.currentTimeMillis());
    }
	public Timestamp getDatahora() {
		return data_hora;
	}

}
