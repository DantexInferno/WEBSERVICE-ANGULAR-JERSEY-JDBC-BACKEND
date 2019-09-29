package com.angular.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.angular.rest.conexion.Conexion;
import com.angular.rest.vo.FacturaVO;


public class FacturaDAO {

	public ArrayList<FacturaVO> obtenerListaFacturas() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		FacturaVO miFacturaVO=new FacturaVO();
		ArrayList<FacturaVO> listaFacturas = null;
		
		
		
		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM factura";

		try {
			if (connection != null) {
				listaFacturas = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					miFacturaVO = new FacturaVO();
					
					miFacturaVO.setNumfactura(result.getInt("numfactura"));
					miFacturaVO.setNumlinea(result.getString("numlinea"));
					miFacturaVO.setFechaemision(result.getDate("fechaemision"));
					miFacturaVO.setFacvalor(result.getDouble("facvalor"));	
					
					
					
					
					listaFacturas.add(miFacturaVO);
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la factura: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaFacturas;
	}
	
	public FacturaVO actualizarFactura(FacturaVO miFacturaVO) {
		String resultado = "";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();
		try {
			String consulta = "UPDATE factura "
					+ " SET facvalor = ?"
					+ " WHERE numfactura= ? ";
			PreparedStatement preStatement = connection.prepareStatement(consulta);

			preStatement.setDouble(1, miFacturaVO.getFacvalor());
			preStatement.setInt(2, miFacturaVO.getNumfactura());
			
			
			
			preStatement.executeUpdate();

			resultado = "Se ha Actualizado la factura satisfactoriamente";

			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "No se pudo actualizar la factura";
		}
		return miFacturaVO;
	}
	
	public String eliminarFactura(int id) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();

		String resp = "";
		try {
			String sentencia = "DELETE FROM factura WHERE numfactura= ? ";

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setInt(1, id);

			statement.executeUpdate();

			resp = "La factura se ha eliminado exitosamente";
			statement.close();
			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "No se pudo eliminar la factura";
		}
		return resp;
	}
	
	public FacturaVO consultarFacturaIndividual(int id) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		
		
		
		FacturaVO miFacturaVO = null;
		System.out.println("numFactura: "+id);

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM factura where numfactura = '"+id+"'";
		System.out.println(consulta);
		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				

				if (result.next() == true) {
					miFacturaVO = new FacturaVO();
					
					miFacturaVO.setNumfactura(result.getInt("numfactura"));
					miFacturaVO.setNumlinea(result.getString("numlinea"));
					miFacturaVO.setFechaemision(result.getDate("fechaemision"));
					miFacturaVO.setFacvalor(result.getDouble("facvalor"));
					
					
					
					
									
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del empleado: " + e.getMessage());
		} finally {
			if (miFacturaVO!=null) {
				System.out.println("Num Factura: "+miFacturaVO.getNumfactura());
				miConexion.desconectar();

			}else{
				System.out.println("Num Factura: "+miFacturaVO);
			}
		}
		
		
		
		return miFacturaVO;
	}
}
