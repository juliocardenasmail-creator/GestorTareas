/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructural;

import modelo.Tarea;

public class TareaConEtiqueta extends TareaDecorator {
    private final String etiqueta;

    public TareaConEtiqueta(Tarea tarea, String etiqueta) {
        super(tarea);
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return tareaBase.toString() + " [#" + etiqueta + "]";
    }
}