package model;

import java.sql.Timestamp;
import java.util.Date;

public class Asistente {

	private int id;
	private int idGimnasio;
	private String dniNiePasaporte;
	private int idLocalidad;
	private boolean activo;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private Float cuotaMensual;

	/**
	 * 
	 */
	public Asistente() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param dniNiePasaporte
	 * @param idLocalidad
	 * @param activo
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 * @param cuotaMensual
	 */
	public Asistente(int id, int idGimnasio, String dniNiePasaporte, int idLocalidad, boolean activo, String nombre,
			String apellidos, Timestamp fechaNacimiento, Float cuotaMensual) {
		super();
		this.id = id;
		this.idGimnasio = idGimnasio;
		this.dniNiePasaporte = dniNiePasaporte;
		this.idLocalidad = idLocalidad;
		this.activo = activo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.cuotaMensual = cuotaMensual;
	}

	/**
	 * 
	 * @return Getters y Setters
	 */
	public int getId() {
		return id;
	}

	public int getIdGimnasio() {
		return idGimnasio;
	}

	public void setIdGimnasio(int idGimnasio) {
		this.idGimnasio = idGimnasio;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDniNiePasaporte() {
		return dniNiePasaporte;
	}

	public void setDniNiePasaporte(String dniNiePasaporte) {
		this.dniNiePasaporte = dniNiePasaporte;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Float getCuotaMensual() {
		return cuotaMensual;
	}

	public void setCuotaMensual(float f) {
		this.cuotaMensual = (float) f;
	}

	@Override
	public String toString() {
		return "Asistente [dniNiePasaporte=" + dniNiePasaporte + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ "]";
	}

}
