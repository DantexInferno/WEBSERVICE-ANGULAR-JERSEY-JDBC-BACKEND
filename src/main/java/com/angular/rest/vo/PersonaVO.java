package com.angular.rest.vo;

public class PersonaVO {

	private int id;
	private String nombre;
	private String apellido;
	private String telefonofijo;
	private String fecnacimiento;
	private String documento;
	
	
	
	public PersonaVO() {
		super();
	}



	public PersonaVO(int id, String nombre, String apellido, String telefonofijo, String fecnacimiento,
			String documento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefonofijo = telefonofijo;
		this.fecnacimiento = fecnacimiento;
		this.documento = documento;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getTelefonofijo() {
		return telefonofijo;
	}



	public void setTelefonofijo(String telefonofijo) {
		this.telefonofijo = telefonofijo;
	}



	public String getFecnacimiento() {
		return fecnacimiento;
	}



	public void setFecnacimiento(String fecnacimiento) {
		this.fecnacimiento = fecnacimiento;
	}



	public String getDocumento() {
		return documento;
	}



	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
}
