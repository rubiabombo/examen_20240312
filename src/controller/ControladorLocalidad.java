package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Localidad;



public class ControladorLocalidad {

	/**
	 * 
	 * @return
	 */
	public static List<Localidad> findAll() {
		List<Localidad> lista = new ArrayList<Localidad>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from localidad");
			
			while (rs.next()) {
				Localidad c = new Localidad();
				c.setId(rs.getInt("id"));
				c.setLocalidad(rs.getString("localidad"));
				lista.add(c);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}
}
