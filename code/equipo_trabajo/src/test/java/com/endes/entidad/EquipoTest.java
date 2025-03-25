package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EquipoTest {

    private Equipo equipo;
    Desarrollador desarrollador1, desarrollador2, desarrollador3;

    @BeforeEach
    void setUp() throws Exception {
        equipo = new Equipo();
    }

    @Test
    @DisplayName("Añadir un miembro con DNI único no lanza excepción; el duplicado sí")
    void testAñadirMiembroDuplicado() {
        Personal dev1 = new Desarrollador("123A", "Ana", 1000.0, "Java");
        Personal devDuplicado = new Desarrollador("123A", "OtroNombre", 1100.0, "Python");

        // Primer miembro → no debe lanzar excepción
        assertDoesNotThrow(() -> equipo.añadirMiembro(dev1),
            "No debería lanzarse excepción al añadir un miembro único");

        // Segundo miembro con mismo DNI → debe lanzar excepción
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> equipo.añadirMiembro(devDuplicado),
            "Se esperaba una excepción por DNI duplicado"
        );

    }
    
    
    /**
     * Debes implementar esta prueba para verificar que se puede
     * añadir un miembro correctamente a la lista del equipo.
     *
     * Sugerencias:
     * - Crea un objeto Desarrollador (u otro tipo de Personal).
     * - Añádelo con añadirMiembro().
     * - Comprueba que el tamaño de la lista es 1.
     * - Verifica que el miembro añadido es el esperado.
     */
    /*
    @Test
    @DisplayName("Añadir un miembro válido al equipo")
    void testAñadirMiembroValido() {
        // Tu código aquí
    }
    */

    /**
     * Debes implementar esta prueba para verificar que el método
     * listarProductividades() devuelve los valores correctos.
     *
     * Sugerencias:
     * - Añade al menos dos miembros con sueldos conocidos.
     * - Usa un lenguaje como "Java" para que el bonus sea del 10%.
     * - Comprueba que la lista tiene el tamaño correcto.
     * - Verifica que los valores de productividad son los esperados.
     */
    
    @Test
    @DisplayName("Listar las productividades del equipo")
    void testListarProductividades() {
        int productividadesEsperadas = 3;
        desarrollador1 = new Desarrollador("29292929T", "Juan", 1500.0, "Python");
		desarrollador2 = new Desarrollador("29392629T", "Pepe", 1500.0, "Java");
		desarrollador3 = new Desarrollador("29292000T", "Maria", 1500.0, "C");
		equipo.añadirMiembro(desarrollador1);
		equipo.añadirMiembro(desarrollador2);
		equipo.añadirMiembro(desarrollador3);
        assertEquals(productividadesEsperadas, equipo.listarProductividades().size(), "El numero de productividades obtenido no coincide con el esperado");
    }
    
    /**
     * Verifica que un equipo nuevo se inicializa con la lista de miembros vacía.
     */
    @Test
    @DisplayName("El equipo debe comenzar con la lista de miembros vacía")
    void testEquipoInicialVacio() {
        assertNotNull(equipo.getMiembros(), "La lista de miembros no debe ser null");
        assertEquals(0, equipo.getMiembros().size(), "El equipo debe comenzar vacío");
    }

    /**
     * Verifica que no se puede añadir un miembro null al equipo.
     * Debe lanzarse IllegalArgumentException con el mensaje adecuado.
     */
    @Test
    @DisplayName("No se permite añadir un miembro null al equipo")
    void testAñadirMiembroNull() {
          
    }
    
}
