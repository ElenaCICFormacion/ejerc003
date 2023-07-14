package cic.es.project003;

import java.util.Objects;

public class Alumno {
	
	private int numeracion;
	private String nombre;
	private String apellidos;
	
	public Alumno(String nombre, String apellidos) {
	
		
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	

	public Alumno(int numeracion, String nombre, String apellidos) {

		this.numeracion = numeracion;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}



	public Alumno() {
	}

	public int getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(int numeracion) {
		this.numeracion = numeracion;
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

	@Override
	public String toString() {
		return "Alumno [numeracion=" + numeracion + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(numeracion);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return numeracion == other.numeracion;
	}
	
	
	
	
	
	
	
	

}
