package com.unu.poo2.beans;

public class Editorial {
	private int ideditorial;
	private String nomEditorial;
	private String contacto;
	private String telefono;

	public int getIdeditorial() {
		return ideditorial;
	}

	public void setIdeditorial(int ideditorial) {
		this.ideditorial = ideditorial;
	}

	public String getNomEditorial() {
		return nomEditorial;
	}

	public void setNomEditorial(String nomEditorial) {
		this.nomEditorial = nomEditorial;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Editorial(int ideditorial, String nomEditorial, String contacto, String telefono) {
		this.ideditorial = ideditorial;
		this.nomEditorial = nomEditorial;
		this.contacto = contacto;
		this.telefono = telefono;
	}

	public Editorial() {
	}
	
}
