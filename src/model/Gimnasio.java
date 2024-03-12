package model;

public class Gimnasio {

	private int id;
	private String descripcion;

	/**
	 * 
	 */
	public Gimnasio() {
		super();

	}

	/**
	 * 
	 * @param id
	 * @param descripcion
	 */
	public Gimnasio(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}

}