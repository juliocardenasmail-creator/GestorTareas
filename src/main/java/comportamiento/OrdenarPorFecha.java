/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comportamiento;

import modelo.Tarea;

public class OrdenarPorFecha implements OrdenamientoStrategy {

    @Override
    public int compare(Tarea t1, Tarea t2) {
        return t1.getFechaCreacion().compareTo(t2.getFechaCreacion());
    }

    @Override
    public String getNombre() {
        return "FECHA";
    }
}
