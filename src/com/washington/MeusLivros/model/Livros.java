package com.washington.MeusLivros.model;

public class Livros {
	protected int id;
	protected String titulo;
	protected String autor;
	protected String anoLancamento;
	protected String resumo;
	
	public Livros() {	
	}
	
	public Livros(int id) {
		this.id = id;
	}
	
	public Livros(int id, String titulo,String autor, String anoLancamento, String resumo) {
		this(titulo,autor,anoLancamento,resumo);
		this.id = id;
	}
	
	public Livros(String titulo, String autor, String anoLancamento, String resumo) {
		this.titulo = titulo;
		this.autor = autor;
		this.anoLancamento = anoLancamento;
		this.resumo = resumo;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo =  titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getAnoLancamento() {
		return anoLancamento;
	}
	
	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	public String getResumo() {
		return resumo;
	}
	
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
}
