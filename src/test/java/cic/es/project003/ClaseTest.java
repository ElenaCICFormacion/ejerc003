package cic.es.project003;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClaseTest {


	Clase cut;
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testClase() {
		cut= new Clase();
		cut.crearAlumno("nombre3", "apellidos");
		cut.crearAlumno("nombre4", "apellidos");
		cut.escribirTXT();
		Clase comprobacion= new Clase();
		boolean resultado= comprobacion.getAlumnos().isEmpty();
		assertEquals(resultado, false);
		
	}

	@Test
	void testCrearAlumno() {
		cut= new Clase();
		boolean resultado= cut.crearAlumno("", "apellidos");
		assertEquals(resultado, false);
	}



	@Test
	void testEliminarAlumno() {
		cut=new Clase();
		boolean resultado=cut.eliminarAlumno(3);
		assertEquals(resultado, true);
	}
	
	

	@Test
	void testRecorrerLista() {
		cut= new Clase();
		boolean resultado=cut.recorrerLista();
		assertEquals(resultado, true);
	}

	@Test
	void testRecogerAlumnosTxt() {
		cut= new Clase();
		cut.getAlumnos().clear();
		boolean recoger= cut.recogerAlumnosTxt();
		assertEquals(cut.getAlumnos().isEmpty(), false);
	}

	@Test
	void testEscribirTXT() {
		cut =new Clase();
		File file= new File(cut.getRuta());
		if(file.exists()) {
			file.delete();
		}
		cut.crearAlumno("nombre", "apellido");
		boolean escribir= cut.escribirTXT();
		assertEquals(file.exists(), true);
	}
	
	@Test
	void actualizarAlumno(){
		cut=new Clase();
		cut.crearAlumno("nombre3", "apellidos");
		cut.crearAlumno("nombre4", "apellidos");
		cut.crearAlumno("nombre3", "apellidos");
		cut.crearAlumno("nombre4", "apellidos");
		boolean resultado=cut.actualizarAlumno(1, new Alumno("nombreAlterado", "apellidos alterados"));
		assertEquals(resultado, true);
	}

}
