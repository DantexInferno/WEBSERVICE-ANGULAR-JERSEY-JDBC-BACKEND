package com.angular.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.angular.rest.conexion.Conexion;
import com.angular.rest.vo.EquipoVO;

public class EquipoDAO {

	
	public EquipoVO registrarEquipo(EquipoVO miEquipoVO) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "INSERT INTO equipo (numlinea,marca,descripcion,estado)"
				+ "  VALUES (?,?,?,?)";
		

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miEquipoVO.getNumlinea());
			preStatement.setString(2, miEquipoVO.getMarca());
			preStatement.setString(3, miEquipoVO.getDescripcion());
			preStatement.setString(4, miEquipoVO.getEstado());
			
			preStatement.execute();

			resultado = "Registro Exitoso";

		} catch (SQLException e) {
			System.out.println("No se pudo registrar el equipo: " + e.getMessage());
			resultado = "No se pudo registrar el equipo";
		} finally {
			conexion.desconectar();
		}

		return miEquipoVO;
	}
	
	
	public ArrayList<EquipoVO> obtenerListaEquipos() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EquipoVO miEquipoVO=new EquipoVO();
		ArrayList<EquipoVO> listaEquipos = null;
		
		
		
		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM equipo";

		try {
			if (connection != null) {
				listaEquipos = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					miEquipoVO = new EquipoVO();
					
					miEquipoVO.setEquiposerial(result.getInt("equiposerial"));
					miEquipoVO.setNumlinea(result.getString("numlinea"));
					miEquipoVO.setMarca(result.getString("marca"));
					miEquipoVO.setDescripcion(result.getString("descripcion"));
					miEquipoVO.setEstado(result.getString("estado"));
					
					
					
					listaEquipos.add(miEquipoVO);
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del equipo: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEquipos;
	}
	
	public EquipoVO actualizarEquipo(EquipoVO miEquipoVO) {
		String resultado = "";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();
		try {
			String consulta = "UPDATE equipo "
					+ " SET numlinea = ? ,descripcion=?, estado=? "
					+ " WHERE equiposerial= ? ";
			PreparedStatement preStatement = connection.prepareStatement(consulta);

			preStatement.setString(1, miEquipoVO.getNumlinea());
			preStatement.setString(2, miEquipoVO.getDescripcion());
			preStatement.setString(3, miEquipoVO.getEstado());
			preStatement.setInt(4, miEquipoVO.getEquiposerial());;
			
			
			
			preStatement.executeUpdate();

			resultado = "Se ha Actualizado el equipo satisfactoriamente";

			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "No se pudo actualizar el equipo";
		}
		return miEquipoVO;
	}
	
	public String eliminarEquipo(int id) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();

		String resp = "";
		try {
			String sentencia = "DELETE FROM equipo WHERE equiposerial= ? ";

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setInt(1, id);

			statement.executeUpdate();

			resp = "El equipo se ha eliminado exitosamente";
			statement.close();
			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "No se pudo eliminar el equipo";
		}
		return resp;
	}
	
	public EquipoVO consultarEquipoIndividual(int id) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		
		
		
		EquipoVO miEquipoVO = null;
		System.out.println("Documento: "+id);

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM equipo where equiposerial = '"+id+"'";
		System.out.println(consulta);
		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				

				if (result.next() == true) {
					miEquipoVO = new  EquipoVO();
					
					miEquipoVO.setEquiposerial(result.getInt("equiposerial"));
					miEquipoVO.setNumlinea(result.getString("numlinea"));
					miEquipoVO.setMarca(result.getString("marca"));
					miEquipoVO.setDescripcion(result.getString("descripcion"));
					miEquipoVO.setEstado(result.getString("estado"));
					
					
					
					
									
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del empleado: " + e.getMessage());
		} finally {
			if (miEquipoVO!=null) {
				System.out.println("Nombre Equipo: "+miEquipoVO.getEquiposerial());
				miConexion.desconectar();

			}else{
				System.out.println("Nombre Equipo: "+miEquipoVO);
			}
		}
		
		
		
		return miEquipoVO;
	}
}
