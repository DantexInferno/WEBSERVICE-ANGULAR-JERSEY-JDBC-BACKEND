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

import com.angular.rest.dao.EquipoDAO;
import com.angular.rest.vo.EquipoVO;

 

@XmlRootElement
@Path("/equipo")
public class EquipoService {
	
	EquipoDAO midao=new EquipoDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaEquipo() {
	
		return Response
	      .status(200)
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Credentials", "true")
	      .header("Access-Control-Allow-Headers",
	        "origin, content-type, accept, authorization")
	      .header("Access-Control-Allow-Methods", 
	        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	      .entity(midao.obtenerListaEquipos())
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
	      .entity(midao.consultarEquipoIndividual(linea))
	      .build();	
}
	
	
	@POST
	@Path("/registrar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarPersona(EquipoVO miEquipoVO) {
		
		return Response
			      .status(200)
			      .header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			      .entity(midao.registrarEquipo(miEquipoVO))
			      .build();	
	}
	
	@PUT
	@Path("/{numfactura}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarEquipo(@PathParam("numfactura") int linea, EquipoVO miEquipoVO) {
		
			return Response
				      .status(200)
				      .header("Access-Control-Allow-Origin", "*")
				      .header("Access-Control-Allow-Credentials", "true")
				      .header("Access-Control-Allow-Headers",
				        "origin, content-type, accept, authorization")
				      .header("Access-Control-Allow-Methods", 
				        "POST, PUT")
				      .entity(midao.actualizarEquipo(miEquipoVO))
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
	      .entity(midao.eliminarEquipo(id))
	      .build();
	}
}
