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

import com.angular.rest.dao.LineaDAO;
import com.angular.rest.vo.LineaVO;


@XmlRootElement
@Path("/linea")
public class LineaService {
	
	LineaDAO midao=new LineaDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaLinea() {
	
		return Response
	      .status(200)
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Credentials", "true")
	      .header("Access-Control-Allow-Headers",
	        "origin, content-type, accept, authorization")
	      .header("Access-Control-Allow-Methods", 
	        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	      .entity(midao.obtenerListaLinea())
	      .build();	
}
	
	@GET
	@Path("/{linea}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultaIndividual(@PathParam("linea") String linea) {
	
		return Response
	      .status(200)
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Credentials", "true")
	      .header("Access-Control-Allow-Headers",
	        "origin, content-type, accept, authorization")
	      .header("Access-Control-Allow-Methods", 
	        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	      .entity(midao.consultarLineaIndividual(linea))
	      .build();	
}
	
	@POST
	@Path("/registrar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarPersona(LineaVO miLineaVO) {
		
		return Response
			      .status(200)
			      .header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			      .entity(midao.registrarLinea(miLineaVO))
			      .build();	
	}
	
	
	@PUT
	@Path("/{numerolinea}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarPersona(@PathParam("numerolinea")String linea, LineaVO miLineaVO) {
		
			return Response
				      .status(200)
				      .header("Access-Control-Allow-Origin", "*")
				      .header("Access-Control-Allow-Credentials", "true")
				      .header("Access-Control-Allow-Headers",
				        "origin, content-type, accept, authorization")
				      .header("Access-Control-Allow-Methods", 
				        "POST, PUT")
				      .entity(midao.actualizarLinea(miLineaVO))
				      .build();	
		
		
	}
	
	
	@DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response eliminarEquipo(@PathParam("id") String id) {
		return Response
	      .status(200)
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Credentials", "true")
	      .header("Access-Control-Allow-Headers",
	        "origin, content-type, accept, authorization")
	      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	      .entity(midao.eliminarLinea(id))
	      .build();
	}

}
