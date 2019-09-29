package com.angular.rest.vo;

import java.sql.Date;

public class FacturaVO {

	private int numfactura ;
	private String numlinea ;
	private Date fechaemision;
	private double facvalor ;
	
	
	
	public FacturaVO() {
		super();
	}
	public FacturaVO(int numfactura, String numlinea, Date fechaemision, double facvalor) {
		super();
		this.numfactura = numfactura;
		this.numlinea = numlinea;
		this.fechaemision = fechaemision;
		this.facvalor = facvalor;
	}
	public int getNumfactura() {
		return numfactura;
	}
	public void setNumfactura(int numfactura) {
		this.numfactura = numfactura;
	}
	public String getNumlinea() {
		return numlinea;
	}
	public void setNumlinea(String numlinea) {
		this.numlinea = numlinea;
	}
	public Date getFechaemision() {
		return fechaemision;
	}
	public void setFechaemision(Date fechaemision) {
		this.fechaemision = fechaemision;
	}
	public double getFacvalor() {
		return facvalor;
	}
	public void setFacvalor(double facvalor) {
		this.facvalor = facvalor;
	}
	
	
}
