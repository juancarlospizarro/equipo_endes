package com.endes;
import com.endes.entidad.Desarrollador;
import com.endes.entidad.Equipo;
import com.endes.entidad.LiderEquipo;
import com.endes.entidad.Personal;
import com.endes.entidad.ResponsablePruebas;

public class App {
    public static void main(String[] args) {
        // Crear equipo
        Equipo equipo = new Equipo();

        // Crear objetos de Personal
        Desarrollador dev1 = new Desarrollador("123A", "Ana", 1000.0, "Java");
        Desarrollador dev2 = new Desarrollador("124B", "Luis", 950.0, "C++");

        ResponsablePruebas tester1 = new ResponsablePruebas("125C", "Sara", 900.0, 10);
        ResponsablePruebas tester2 = new ResponsablePruebas("126D", "David", 880.0, 3);

        LiderEquipo lider = new LiderEquipo("127E", "Marta", 1200.0, 5);

        // Añadir al equipo
        equipo.añadirMiembro(dev1);
        equipo.añadirMiembro(dev2);
        equipo.añadirMiembro(tester1);
        equipo.añadirMiembro(tester2);
        equipo.añadirMiembro(tester2);
        equipo.añadirMiembro(lider);

        // Mostrar información
        System.out.println("=== PRODUCTIVIDAD INDIVIDUAL ===");
        for (Personal p : equipo.getMiembros()) {
            System.out.println(p.getNombre() + " (" + p.getClass().getSimpleName() + "): " +
                               p.calcularProductividad());
        }

        System.out.println("\n=== PRODUCTIVIDAD TOTAL DEL EQUIPO ===");
        double total = equipo.listarProductividades()
                             .stream()
                             .mapToDouble(Double::doubleValue)
                             .sum();
        System.out.println("Total productividad: " + total);
    }
}
