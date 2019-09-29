package com.angular.rest.vo;

public class EquipoVO {

	private int equiposerial;
	private String numlinea;
	private String marca;
	private String descripcion;
	private String estado;
	
	
	
	public EquipoVO() {
		super();
	}
	public EquipoVO(int equiposerial, String numlinea, String marca, String descripcion, String estado) {
		super();
		this.equiposerial = equiposerial;
		this.numlinea = numlinea;
		this.marca = marca;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	public int getEquiposerial() {
		return equiposerial;
	}
	public void setEquiposerial(int equiposerial) {
		this.equiposerial = equiposerial;
	}
	public String getNumlinea() {
		return numlinea;
	}
	public void setNumlinea(String numlinea) {
		this.numlinea = numlinea;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
