package com.endes.entidad;
/**
 * Clase que representa a un Líder de Equipo, heredera de la clase abstracta Personal.
 * 
 * Su productividad se incrementa en un 5% por cada año de experiencia.
 * Este rol representa a una persona encargada de coordinar, guiar y motivar al equipo.
 * 
 * Es especialmente relevante en entornos colaborativos y metodologías ágiles.
 * 
 * @author 
 */
public class LiderEquipo extends Personal {
    private int añosExperiencia;

    /**
     * Constructor para crear un objeto Líder de Equipo.
     * 
     * @param dni              Documento de identidad
     * @param nombre           Nombre del líder
     * @param sueldoBase       Sueldo base
     * @param añosExperiencia  Años de experiencia en liderazgo
     * @throws IllegalArgumentException si los años de experiencia son negativos
     */
    public LiderEquipo(String dni, String nombre, double sueldoBase, int añosExperiencia) {
        super(dni, nombre, sueldoBase);
        setAñosExperiencia(añosExperiencia);
    }

    /**
     * Devuelve los años de experiencia del líder.
     * 
     * @return años de experiencia como entero
     */
    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    /**
     * Establece los años de experiencia del líder.
     * 
     * @param añosExperiencia nuevos años de experiencia
     * @throws IllegalArgumentException si el valor es negativo
     */
    public void setAñosExperiencia(int añosExperiencia) {
        if (añosExperiencia < 0) {
            throw new IllegalArgumentException("Los años de experiencia no pueden ser negativos.");
        }
        this.añosExperiencia = añosExperiencia;
    }

    /**
     * Calcula la productividad del líder de equipo.
     * Se incrementa en un 5% por cada año de experiencia.
     * 
     * @return productividad final
     */
    @Override
    public double calcularProductividad() {
        return getSueldoBase() * (1 + 0.05 * añosExperiencia);
    }
}
