package com.endes.entidad;

/**
 * Clase para la creación del responsable de pruebas que hereda de la clase Personal
 * 
 * @author Juan Carlos Pizarro Alonso
 */
public class ResponsablePruebas extends Personal {
    private int bugsDetectados;

    /**
     * Método constructor para la clase ResponsablePruebas
     * 
     * @param dni
     * @param nombre
     * @param sueldoBase
     * @param bugsDetectados
     */
    public ResponsablePruebas(String dni, String nombre, double sueldoBase, int bugsDetectados) {
        super(dni, nombre, sueldoBase);
        setBugsDetectados(bugsDetectados);
    }

    /**
     * Método que devuelve el valor del atributo bugsDetectados
     * 
     * @return bugsDetectados Valor de bugs detectados
     */
    public int getBugsDetectados() {
        return bugsDetectados;
    }

    /**
     * Método que establece el valor del atributo bugsDetectados
     * 
     * @param bugsDetectados Valor nuevo introducido en el atributo bugsDetectados
     * @throws IllegalArgumentException Devuelve una excepción en caso de ser negativo
     */
    public void setBugsDetectados(int bugsDetectados) {
        if (bugsDetectados < 0) {
            throw new IllegalArgumentException("El número de bugs detectados no puede ser negativo.");
        }
        this.bugsDetectados = bugsDetectados;
    }
   
    @Override
    /**
     * Método que devuelve la productividad en base al atributo bugsDetectados
     */
    public double calcularProductividad() {
        return getSueldoBase() * (1 + 0.02 * bugsDetectados);
    }
}
