/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Subclase que respeta LSP (puede usarse donde se espere una Tarea).
 */
public class TareaPrioritaria extends Tarea {
    private int prioridad;

    public TareaPrioritaria(String id, String descripcion, int prioridad) {
        super(id, descripcion);
        this.prioridad = normalize(prioridad);
    }

    // Constructor para reconstrucción desde persistencia
    public TareaPrioritaria(String id, String descripcion, java.time.LocalDate fechaCreacion, boolean completada, int prioridad) {
        super(id, descripcion, fechaCreacion, completada);
        this.prioridad = normalize(prioridad);
    }

    private int normalize(int p) {
        if (p < 1) return 1;
        if (p > 5) return 5;
        return p;
    }

    @Override
    public String getTipo() {
        return "PRIORITARIA";
    }

    @Override
    public int getPrioridad() {
        return prioridad;
    }
}