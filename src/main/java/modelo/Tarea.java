/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase base para tareas.
 */
public class Tarea {
    protected String id;
    protected String descripcion;
    protected LocalDate fechaCreacion;
    protected boolean completada;

    // Constructor para creación normal (genera fecha actual)
    public Tarea(String id, String descripcion) {
        this(id, descripcion, LocalDate.now(), false);
    }

    // Constructor que permite reconstruir desde persistencia (preserva id y fecha)
    public Tarea(String id, String descripcion, LocalDate fechaCreacion, boolean completada) {
        this.id = Objects.requireNonNull(id, "id no puede ser null");
        this.descripcion = Objects.requireNonNull(descripcion, "descripcion no puede ser null");
        this.fechaCreacion = (fechaCreacion == null) ? LocalDate.now() : fechaCreacion;
        this.completada = completada;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    // Tipo por defecto
    public String getTipo() {
        return "NORMAL";
    }

    // Prioridad por defecto (1)
    public int getPrioridad() {
        return 1;
    }

    @Override
    public String toString() {
    return String.format("%s [%s] %s | %s | Creada: %s",
            completada ? "✓" : " ",
            id,
            getTipo(),
            descripcion,
            fechaCreacion);
    }

    /**
     * Formato de archivo: id|descripcion|fechaISO|completada|prioridad
     */
    public String toFileFormat() {
        return String.format("%s|%s|%s|%s|%d",
                id,
                descripcion.replace("|", " "), // evitar separador en descripción
                fechaCreacion.toString(),
                Boolean.toString(completada),
                getPrioridad());
    }
}
