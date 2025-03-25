package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DesarrolladorTest {
	
	Desarrollador desarrollador1, desarrollador2, desarrollador3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		desarrollador1 = new Desarrollador("29292929T", "Juan", 1500.0, "Python");
		desarrollador2 = new Desarrollador("29392629T", "Pepe", 1500.0, "Java");
		desarrollador3 = new Desarrollador("29292000T", "Maria", 1500.0, "C");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@DisplayName("Prueba para el método getDni()")
	void testGetDni() {
		assertEquals("29292929T", desarrollador1.getDni(), "El DNI obtenido no corresponde con el esperado");
	}

	@Test
	@DisplayName("Prueba para el método getNombre()")
	void testGetNombre() {
		assertEquals("Juan", desarrollador1.getNombre(), "El nombre obtenido no corresponde con el esperado");
	}
	
	@Test
	@DisplayName("Prueba para el método getSueldoBase()")
	void testGetSueldoBase() {
		assertEquals(1500.0, desarrollador1.getSueldoBase(), "El sueldo base obtenido no corresponde con el esperado");
	}
	
	@Test
	@DisplayName("Prueba para el método setSueldoBase() con valor positivo")
	void testSetSueldoBasePositivo() {
		double sueldoIntroducido = 2000.0;
		desarrollador1.setSueldoBase(sueldoIntroducido);
		assertEquals(sueldoIntroducido, desarrollador1.getSueldoBase(), "El sueldo base obtenido no corresponde con el esperado");
	}
	
	@Test
	@DisplayName("Prueba para el metodo setSueldoBase() en caso precio negativo")
	void testSetPrecioNegativo() {
	    double sueldoIntroducido = -2000.0;
	    String mensajeEsperado = "El sueldo base no puede ser negativo.";
	    Exception exception = assertThrows(IllegalArgumentException.class, () -> desarrollador1.setSueldoBase(sueldoIntroducido));

	    assertEquals(mensajeEsperado, exception.getMessage(), "El mensaje obtenido no se corresponde con el mensaje esperado");
	}
	
	@Test
	@DisplayName("Prueba para el método getLenguajePrincipal()")
	void testGetLenguajePrincipal() {
		String lenguajeEsperado1 = "Python";
		
		assertEquals(lenguajeEsperado1, desarrollador1.getLenguajePrincipal(), "El lenguaje obtenido no corresponde con el esperado");
	}
	
	@Test
	@DisplayName("Prueba para el método calcularProductividad()")
	void testCalcularProductividad() {
		String lenguajeAsignado = desarrollador1.getLenguajePrincipal();
		double productividad = desarrollador1.getSueldoBase();
		if(lenguajeAsignado == "Python" || lenguajeAsignado == "Java") {
			productividad *= 1.10;
		}
		assertEquals(productividad, desarrollador1.calcularProductividad(), "La productividad obtenidad no corresponde con la esperada");
	}

}
