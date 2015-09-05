package br.com.meu_crud.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import br.com.meu_crud.model.enums.TipoDocEnum;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "titulo, descricao, tamanho" }) })
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(length = 300, nullable = false)
	private String titulo;

	@Column(length = 400, nullable = false)
	private String descricao;

	@Temporal(TemporalType.DATE)
	private Date dataRegistro;

	@Column(precision = 15, scale = 2, nullable = false)
	private BigDecimal tamanho;

	@Lob
	private byte[] conteudo;

	@Enumerated
	private TipoDocEnum tipo;

	public Documento() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public BigDecimal getTamanho() {
		return tamanho;
	}

	public void setTamanho(BigDecimal tamanho) {
		this.tamanho = tamanho;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public TipoDocEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoDocEnum tipo) {
		this.tipo = tipo;
	}

}
