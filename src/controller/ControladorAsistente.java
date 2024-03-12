package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Asistente;






public class ControladorAsistente {

	private static String nombreTabla = "asistente";

	
	/**
	 * 
	 * @param idCategoria
	 * @return
	 */
	public static List<Asistente> findAllByIdGimnasio(int id) {
		List<Asistente> l = new ArrayList<Asistente>();
		
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("select * from asistente where idLocalidad and apellidos  like%Pozo% = " + id);
			while (rs.next()) {
				Asistente a = getEntidadFromResultSet(rs);
				l.add(a);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;		
	}
	private static Asistente getEntidadFromResultSet(ResultSet rs) throws SQLException {
		Asistente a = new Asistente();
		a= new Asistente();
		a.setId(rs.getInt("id"));
		a.setDniNiePasaporte("Dni/Nie/Pasaporte");
		a.setNombre(rs.getString("nombre"));
		a.setApellidos(rs.getString("apellidos"));
		a.setFechaNacimiento(rs.getTimestamp("fechaNacimiento"));
		a.setCuotaMensual(rs.getFloat("cuotaMensual"));
		a.setIdLocalidad(rs.getInt("idLocalidad"));
		
		return a;
	
	}
	/**
	 * 
	 * @param m
	 * @return
	 */
	public static int modificar (Asistente m) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update asistente set dni/Nie/Pasaporte = ?, DNI/NIE/Pasaporte = ?, "
					+ "localidad = ?, nombre = ?, apellidos = ?, activo = ?, fechaDeNacimiento =, cuotaMensual= ? where id = ?");
		
			ps.setString(1, m.getDniNiePasaporte());
			ps.setString(2, m.getNombre());
			ps.setDate(3, new java.sql.Date(m.getFechaNacimiento().getTime()));
			ps.setFloat(4, m.getCuotaMensual());
			ps.setInt(5, m.getIdLocalidad());
			ps.setInt(6, m.getId());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	private static int getSiguientIdValido () {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"select max(id) from usuario");
		
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int maximoIdActual = rs.getInt(1);
				return maximoIdActual + 1;
			}
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @param idPais
	 * @return
	 */
	public static List<Asistente> save(Asistente a) {
		Asistente a1 = null;
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			String idLocalidad = null;
			ResultSet rs = st.executeQuery("select * from asistente where idLocalidad and apellidos  like%Pozo% = " + idLocalidad);
			
			while (rs.next()) {
				
				a1= new Asistente();
				a1.setId(rs.getInt("id"));
				a1.setDniNiePasaporte("Dni/Nie/Pasaporte");
				a1.setNombre(rs.getString("nombre"));
				a1.setApellidos(rs.getString("apellidos"));
				a1.setFechaNacimiento(rs.getTimestamp("fechaNacimiento"));
				a1.setCuotaMensual(rs.getFloat("cuotaMensual"));
				a1.setIdLocalidad(rs.getInt("idLocalidad"));
				
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return (List<Asistente>) a1;
	}


	



}
