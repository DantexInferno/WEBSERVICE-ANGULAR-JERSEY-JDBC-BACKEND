package com.angular.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import com.angular.rest.dao.FacturaDAO;
import com.angular.rest.vo.FacturaVO;

@XmlRootElement
@Path("/factura")
public class FacturaService {

	FacturaDAO midao=new FacturaDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaFactura() {
	
		return Response
	      .status(200)
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Credentials", "true")
	      .header("Access-Control-Allow-Headers",
	        "origin, content-type, accept, authorization")
	      .header("Access-Control-Allow-Methods", 
	        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	      .entity(midao.obtenerListaFacturas())
	      .build();	
}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultaIndividual(@PathParam("id") int linea) {
	
		return Response
	      .status(200)
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Credentials", "true")
	      .header("Access-Control-Allow-Headers",
	        "origin, content-type, accept, authorization")
	      .header("Access-Control-Allow-Methods", 
	        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	      .entity(midao.consultarFacturaIndividual(linea))
	      .build();	
}
	
	
	
	
	@PUT
	@Path("/{numfactura}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarPersona(@PathParam("numfactura") int linea, FacturaVO miFacturaVO) {
		
			return Response
				      .status(200)
				      .header("Access-Control-Allow-Origin", "*")
				      .header("Access-Control-Allow-Credentials", "true")
				      .header("Access-Control-Allow-Headers",
				        "origin, content-type, accept, authorization")
				      .header("Access-Control-Allow-Methods", 
				        "POST, PUT")
				      .entity(midao.actualizarFactura(miFacturaVO))
				      .build();	
		
		
	}
	
	
	@DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response eliminarEquipo(@PathParam("id") int id) {
		return Response
	      .status(200)
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Credentials", "true")
	      .header("Access-Control-Allow-Headers",
	        "origin, content-type, accept, authorization")
	      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	      .entity(midao.eliminarFactura(id))
	      .build();
	}
}
