/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructural;

import modelo.Tarea;

public class TareaUrgente extends TareaDecorator {
    public TareaUrgente(Tarea tarea) {
        super(tarea);
    }

    @Override
    public String toString() {
        return "URGENTE: " + tareaBase.toString();
    }
}