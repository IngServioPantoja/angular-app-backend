package service;

import java.io.Serializable;

import domain.Cuenta;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;
	private String apellido;
	private Cuenta cuenta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}
