package com.endes.entidad;
/**
 * Clase abstracta que representa a un miembro del personal de un equipo.
 * Proporciona información básica común como DNI, nombre y sueldo base.
 * 
 * Las clases hijas deben implementar el método calcularProductividad().
 * 
 * @author 
 */
public abstract class Personal {
    private String dni;
    private String nombre;
    private double sueldoBase;

    /**
     * Constructor para crear un objeto Personal.
     * 
     * @param dni        Documento Nacional de Identidad del personal
     * @param nombre     Nombre del personal
     * @param sueldoBase Sueldo base del personal (debe ser mayor o igual a 0)
     * @throws IllegalArgumentException si algún parámetro no es válido
     */
    public Personal(String dni, String nombre, double sueldoBase) {
        setDni(dni);
        setNombre(nombre);
        setSueldoBase(sueldoBase);
    }

    /**
     * Devuelve el DNI del personal.
     * 
     * @return el DNI como String
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del personal.
     * 
     * @param dni el nuevo DNI
     * @throws IllegalArgumentException si el DNI es nulo o vacío
     */
    public void setDni(String dni) {
        if (dni == null || dni.trim().isEmpty()) {
            throw new IllegalArgumentException("DNI no válido.");
        }
        this.dni = dni;
    }

    /**
     * Devuelve el nombre del personal.
     * 
     * @return el nombre como String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del personal.
     * 
     * @param nombre el nuevo nombre
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no válido.");
        }
        this.nombre = nombre;
    }

    /**
     * Devuelve el sueldo base del personal.
     * 
     * @return el sueldo base como double
     */
    public double getSueldoBase() {
        return sueldoBase;
    }

    /**
     * Establece el sueldo base del personal.
     * 
     * @param sueldoBase el nuevo sueldo base
     * @throws IllegalArgumentException si el sueldo base es negativo
     */
    public void setSueldoBase(double sueldoBase) {
        if (sueldoBase < 0) {
            throw new IllegalArgumentException("El sueldo base no puede ser negativo.");
        }
        this.sueldoBase = sueldoBase;
    }

    /**
     * Método abstracto que debe ser implementado por las subclases.
     * Calcula la productividad del personal en función de sus características.
     * 
     * @return el valor de productividad como double
     */
    public abstract double calcularProductividad();
}
