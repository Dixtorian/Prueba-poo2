package com.unu.poo2.beans;

public class Autor {
	private String codigoAutor;
	private String nacionalidad;
	private String nombreAutor;
	private int idAutor;

	public String getCodigoAutor() {
		return codigoAutor;
	}

	public void setCodigoAutor(String codigoAutor) {
		this.codigoAutor = codigoAutor;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public Autor(String codigoAutor, String nacionalidad, String nombreAutor, int idAutor) {
		this.codigoAutor = codigoAutor;
		this.nacionalidad = nacionalidad;
		this.nombreAutor = nombreAutor;
		this.idAutor = idAutor;
	}

	public Autor() {

	}
	
	
}
