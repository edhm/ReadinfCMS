package com.ehm.ReadingCMS.Model;

public class PostMetadata {
	private long IdPostMetadata;
	private String Clave;
	private String Valor;
	private String Tipo;
	private long IsPost;

	public long getIdPostMetadata() {
		return IdPostMetadata;
	}

	public void setIdPostMetadata(long idPostMetadata) {
		IdPostMetadata = idPostMetadata;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public long getIsPost() {
		return IsPost;
	}

	public void setIsPost(long isPost) {
		IsPost = isPost;
	}
}
