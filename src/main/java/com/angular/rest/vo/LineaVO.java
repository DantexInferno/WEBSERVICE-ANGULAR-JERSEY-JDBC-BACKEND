package com.angular.rest.vo;

public class LineaVO {

	private String numerolinea;
	private int personaid;
	private String estado;
	
	
	
	public LineaVO() {
		super();
	}
	public LineaVO(String numerolinea, int personaid, String estado) {
		super();
		this.numerolinea = numerolinea;
		this.personaid = personaid;
		this.estado = estado;
	}
	public String getNumerolinea() {
		return numerolinea;
	}
	public void setNumerolinea(String numerolinea) {
		this.numerolinea = numerolinea;
	}
	public int getPersonaid() {
		return personaid;
	}
	public void setPersonaid(int personaid) {
		this.personaid = personaid;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
