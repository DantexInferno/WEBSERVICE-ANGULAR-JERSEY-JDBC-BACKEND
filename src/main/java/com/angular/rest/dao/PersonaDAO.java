package com.angular.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.angular.rest.conexion.Conexion;
import com.angular.rest.vo.PersonaVO;



public class PersonaDAO {

	public PersonaVO registrarPersona(PersonaVO miPersonaVO) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "INSERT INTO persona (nombre,apellido,telefonofijo,fecnacimiento,documento)"
				+ "  VALUES (?,?,?,?,?)";
		

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miPersonaVO.getNombre());
			preStatement.setString(2, miPersonaVO.getApellido());
			preStatement.setString(3, miPersonaVO.getTelefonofijo());
			preStatement.setString(4, miPersonaVO.getFecnacimiento());
			preStatement.setString(5, miPersonaVO.getDocumento());
			
			preStatement.execute();

			resultado = "Registro Exitoso";

		} catch (SQLException e) {
			System.out.println("No se pudo registrar la persona: " + e.getMessage());
			resultado = "No se pudo registrar la persona";
		} finally {
			conexion.desconectar();
		}

		return miPersonaVO;
	}
	
	
	
	public ArrayList<PersonaVO> obtenerListaPersonas() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		PersonaVO miPersonaVO=new PersonaVO();
		ArrayList<PersonaVO> listaPersonas = null;
		
		
		
		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM persona";

		try {
			if (connection != null) {
				listaPersonas = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					miPersonaVO = new PersonaVO();
					
					miPersonaVO.setId(result.getInt("id"));
					miPersonaVO.setNombre(result.getString("nombre"));
					miPersonaVO.setApellido(result.getString("apellido"));
					miPersonaVO.setTelefonofijo(result.getString("telefonofijo"));	
					miPersonaVO.setFecnacimiento(result.getString("fecnacimiento"));
					miPersonaVO.setDocumento(result.getString("documento"));
					
					
					
					listaPersonas.add(miPersonaVO);
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaPersonas;
	}
	
	public PersonaVO actualizarPersona(PersonaVO miPersonaVO) {
		String resultado = "";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();
		try {
			String consulta = "UPDATE persona "
					+ " SET nombre = ? ,apellido= ?, telefonofijo=?, fecnacimiento=?,documento=?"
					+ " WHERE id= ? ";
			PreparedStatement preStatement = connection.prepareStatement(consulta);

			preStatement.setString(1, miPersonaVO.getNombre());
			preStatement.setString(2, miPersonaVO.getApellido());
			preStatement.setString(3, miPersonaVO.getTelefonofijo());
			preStatement.setString(4, miPersonaVO.getFecnacimiento());
			preStatement.setString(5, miPersonaVO.getDocumento());
			preStatement.setInt(6, miPersonaVO.getId());
			
			
			preStatement.executeUpdate();

			resultado = "Se ha Actualizado la persona satisfactoriamente";

			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "No se pudo actualizar la persona";
		}
		return miPersonaVO;
	}
	
	public String eliminarPersona(int id) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();

		String resp = "";
		try {
			String sentencia = "DELETE FROM persona WHERE id= ? ";

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setInt(1, id);

			statement.executeUpdate();

			resp = "La persona se ha eliminado exitosamente";
			statement.close();
			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "No se pudo eliminar a la persona";
		}
		return resp;
	}
	
	public PersonaVO consultarPersonaIndividual(int id) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		
		
		
		PersonaVO miPersona = null;
		System.out.println("Documento: "+id);

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM persona where id = '"+id+"'";
		System.out.println(consulta);
		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				

				if (result.next() == true) {
					miPersona = new PersonaVO();
					
					miPersona.setId(result.getInt("id"));
					miPersona.setNombre(result.getString("nombre"));
					miPersona.setApellido(result.getString("apellido"));
					miPersona.setTelefonofijo(result.getString("telefonofijo"));
					miPersona.setFecnacimiento(result.getString("fecnacimiento"));
					miPersona.setDocumento(result.getString("documento"));
					
					
					
					
									
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del empleado: " + e.getMessage());
		} finally {
			if (miPersona!=null) {
				System.out.println("Nombre Persona: "+miPersona.getNombre());
				miConexion.desconectar();

			}else{
				System.out.println("Nombre Persona: "+miPersona);
			}
		}
		
		
		
		return miPersona;
	}
}
