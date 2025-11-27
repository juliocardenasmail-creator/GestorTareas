/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comportamiento;

import modelo.Tarea;

public class OrdenarPorPrioridad implements OrdenamientoStrategy {

    @Override
    public int compare(Tarea t1, Tarea t2) {
        return Integer.compare(t2.getPrioridad(), t1.getPrioridad());
    }

    @Override
    public String getNombre() {
        return "PRIORIDAD";
    }
}
