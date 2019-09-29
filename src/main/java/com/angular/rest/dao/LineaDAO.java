package com.angular.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.angular.rest.conexion.Conexion;
import com.angular.rest.vo.LineaVO;


public class LineaDAO {

	public LineaVO registrarLinea(LineaVO miLineaVO) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		PreparedStatement preStatement2 = null;


		connection = conexion.getConnection();
		String consulta = "INSERT INTO linea (numerolinea,personaid,estado)"
				+ "  VALUES (?,?,?)";
		
		String consulta2 = "INSERT INTO factura (numlinea,fechaemision,facvalor) VALUES(?,DATE_ADD(current_date(), INTERVAL 30 DAY),50000.00);";
		

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miLineaVO.getNumerolinea());
			preStatement.setInt(2, miLineaVO.getPersonaid());
			preStatement.setString(3, miLineaVO.getEstado());
			
			preStatement2 = connection.prepareStatement(consulta2);
			preStatement2.setString(1, miLineaVO.getNumerolinea());

			preStatement.execute();
			preStatement2.execute();


			resultado = "Registro Exitoso";

		} catch (SQLException e) {
			System.out.println("No se pudo registrar el equipo: " + e.getMessage());
			resultado = "No se pudo registrar el equipo";
		} finally {
			conexion.desconectar();
		}

		return miLineaVO;
	}
	
	
	
	public ArrayList<LineaVO> obtenerListaLinea() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		LineaVO miLineaVO=new LineaVO();
		ArrayList<LineaVO> listaLinea = null;
		
		
		
		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM linea";

		try {
			if (connection != null) {
				listaLinea = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					miLineaVO = new LineaVO();
					
					miLineaVO.setNumerolinea(result.getString("numerolinea"));
					miLineaVO.setPersonaid(result.getInt("personaid"));
					miLineaVO.setEstado(result.getString("estado"));					
					
					
					
					listaLinea.add(miLineaVO);
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la linea: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaLinea;
	}
	
	public LineaVO actualizarLinea(LineaVO miLineaVO) {
		String resultado = "";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();
		try {
			String consulta = "UPDATE linea "
					+ " SET estado= ?"
					+ " WHERE numerolinea= ? ";
			PreparedStatement preStatement = connection.prepareStatement(consulta);

			preStatement.setString(1, miLineaVO.getEstado());
			preStatement.setString(2, miLineaVO.getNumerolinea());
			
			
			
			
			preStatement.executeUpdate();

			resultado = "Se ha Actualizado la linea satisfactoriamente";

			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "No se pudo actualizar la linea";
		}
		return miLineaVO;
	}
	
	public String eliminarLinea(String linea) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();

		String resp = "";
		try {
			String sentencia = "DELETE FROM linea WHERE numerolinea= ? ";

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setString(1, linea);

			statement.executeUpdate();

			resp = "La linea se ha eliminado exitosamente";
			statement.close();
			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "No se pudo eliminar la linea";
		}
		return resp;
	}
	
	public LineaVO consultarLineaIndividual(String linea) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		
		
		
		LineaVO miLineaVO = null;
		System.out.println("linea: "+linea);

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM linea where numerolinea = '"+linea+"'";
		System.out.println(consulta);
		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				

				if (result.next() == true) {
					miLineaVO = new LineaVO();
					
					miLineaVO.setNumerolinea(result.getString("numerolinea"));
					miLineaVO.setPersonaid(result.getInt("personaid"));
					miLineaVO.setEstado(result.getString("estado"));
					
					
					
					
					
									
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la linea: " + e.getMessage());
		} finally {
			if (miLineaVO!=null) {
				System.out.println("Numero linea: "+miLineaVO.getNumerolinea());
				miConexion.desconectar();

			}else{
				System.out.println("numero Linea: "+miLineaVO);
			}
		}
		
		
		
		return miLineaVO;
	}
}
