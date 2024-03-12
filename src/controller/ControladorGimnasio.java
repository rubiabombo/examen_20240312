package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Gimnasio;

public class ControladorGimnasio {

	/**
	 * 
	 * @param idPais
	 * @return
	 */
	public static List<Gimnasio> findAllByDescripcion(int idLocalidad) {
		List<Gimnasio> lista = new ArrayList<Gimnasio>();

		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			String descripcion = null;
			ResultSet rs = st.executeQuery("select * from gimnasio where descripcion = " + descripcion);

			while (rs.next()) {
				Gimnasio m = new Gimnasio();
				m.setId(rs.getInt("id"));
				m.setDescripcion(rs.getString("descripcion"));
				lista.add(m);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return lista;
	}

	public static List<Gimnasio> findAllByIdGimnasio(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Gimnasio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}