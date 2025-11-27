/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creacional;

import modelo.Tarea;
import modelo.TareaPrioritaria;
import java.time.LocalDate;

/**
 * Factory simple para crear tareas. Sigue el patrón Factory Method.
 * Mantiene un contador para generar ids legibles.
 */
public class TareaFactory {
    private static int contador = 1;

    public static Tarea crearTarea(String tipo, String descripcion, int prioridad) {
        String id = generarId();
        if ("PRIORITARIA".equalsIgnoreCase(tipo)) {
            return new TareaPrioritaria(id, descripcion, prioridad);
        } else {
            return new Tarea(id, descripcion);
        }
    }

    public static Tarea crearTareaNormal(String descripcion) {
        return crearTarea("NORMAL", descripcion, 1);
    }

    public static Tarea crearTareaPrioritaria(String descripcion, int prioridad) {
        return crearTarea("PRIORITARIA", descripcion, prioridad);
    }

    private static String generarId() {
        return "T" + String.format("%03d", contador++);
    }

    public static void reiniciarContador() {
        contador = 1;
    }

    /**
     * Método para reconstruir una tarea desde los datos de archivo,
     * preservando el id y la fecha.
     */
    public static Tarea crearTareaDesdeArchivo(String id, String descripcion, LocalDate fechaCreacion, boolean completada, int prioridad) {
        if (prioridad > 1) {
            return new TareaPrioritaria(id, descripcion, fechaCreacion, completada, prioridad);
        } else {
            return new Tarea(id, descripcion, fechaCreacion, completada);
        }
    }
}