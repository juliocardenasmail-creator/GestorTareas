/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructural;

import modelo.Tarea;

/**
 * Decorator para Tarea. Hereda de Tarea para mantener polimorfismo.
 * Evitar crear estado inconsistente: usamos la tarea base para delegar.
 */
public abstract class TareaDecorator extends Tarea {
    protected final Tarea tareaBase;

    public TareaDecorator(Tarea tarea) {
        // construimos usando los datos de la tarea base para preservar id/fecha
        super(tarea.getId(), tarea.getDescripcion(), tarea.getFechaCreacion(), tarea.isCompletada());
        this.tareaBase = tarea;
    }

    @Override
    public String getDescripcion() {
        return tareaBase.getDescripcion();
    }

    @Override
    public boolean isCompletada() {
        return tareaBase.isCompletada();
    }

    @Override
    public void setCompletada(boolean completada) {
        tareaBase.setCompletada(completada);
    }

    @Override
    public String getTipo() {
        return tareaBase.getTipo();
    }

    @Override
    public int getPrioridad() {
        return tareaBase.getPrioridad();
    }

    @Override
    public String toFileFormat() {
        return tareaBase.toFileFormat();
    }
}