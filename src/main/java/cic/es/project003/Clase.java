package cic.es.project003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Clase {

	private ArrayList<Alumno> alumnos;
	private static String ruta="documents/alumnos.txt";
	
	

	
	
	public Clase() {
		this.alumnos = new ArrayList<Alumno>();
		
		recogerAlumnosTxt();
	}
	

	public boolean crearAlumno(String nombre, String apellidos) {
		if(nombre.equalsIgnoreCase("") || apellidos.equalsIgnoreCase("")) {
			//los campos deben exitir
			return false;
		}else {
			int numero=alumnos.size();
			Alumno nuevo = new Alumno(numero, nombre, apellidos);
			alumnos.add(nuevo);
			return true;
		}
	}
	
	public boolean actualizarAlumno(int numero, Alumno nuevo) {
		boolean a=false;
		int count=0;
			for(Alumno alum: alumnos) {
				if(alum.getNumeracion()==numero) {
					alum.setApellidos(nuevo.getApellidos());
					alum.setNombre(nuevo.getNombre());
					a= true;
					escribirTXT();
					break;
				}
				count++;
			}
			return a;
	}
		
		
	public boolean eliminarAlumno(int numero) {
		boolean a=false;
		int count=0;
			for(Alumno alum: alumnos) {
				if(alum.getNumeracion()==numero) {
					alumnos.remove(count);
					escribirTXT();
					a=true;
					break;
				}
				count++;
			}
			return a;
}
		
		public boolean recorrerLista() {
			if(alumnos.isEmpty()) {
				return false;
			}else {
			for(Alumno alum: alumnos) {
				//rrecorremos la lista
			}
			return true;
			}
		}
		
		public boolean recogerAlumnosTxt() {
			try {
				File file= new File(this.ruta);
				if(!file.exists()) {
						file.createNewFile();
				}
				BufferedReader br= new BufferedReader(new FileReader(file));
				String linea;
				while((linea=br.readLine())!=null) {
			
					String apellidos= linea.substring(linea.lastIndexOf("|") +1, linea.length());
					linea= linea.substring(0, linea.lastIndexOf("|"));
					String nombre= linea.substring(linea.lastIndexOf("|") +1, linea.length());
					linea= linea.substring(0, linea.lastIndexOf("|"));
					int numero= Integer.valueOf(linea);
					Alumno a= new Alumno(numero, nombre, apellidos);
					alumnos.add(a);
				}
				br.close();
				return true;
			
				
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			
		}
		
		public boolean escribirTXT() {
			try {
			File file= new File(this.ruta);
			if(!file.exists()) {
					file.createNewFile();
			}
			BufferedWriter bw= new BufferedWriter(new FileWriter(file, false));
			for(Alumno alum:alumnos) {
				bw.write(String.valueOf(alum.getNumeracion()).concat("|"));
				bw.write(alum.getNombre().concat("|"));
				bw.write(alum.getApellidos());
				bw.newLine();
			}
			bw.close();
			return true;
		
			
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

		public ArrayList<Alumno> getAlumnos() {
			return alumnos;
		}

		public void setAlumnos(ArrayList<Alumno> alumnos) {
			this.alumnos = alumnos;
		}

		public static String getRuta() {
			return ruta;
		}
	
	
	

}
