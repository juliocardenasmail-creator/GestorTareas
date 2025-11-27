/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comportamiento;

import modelo.Tarea;

public class OrdenarPorNombre implements OrdenamientoStrategy {

    @Override
    public int compare(Tarea t1, Tarea t2) {
        return t1.getDescripcion().compareToIgnoreCase(t2.getDescripcion());
    }

    @Override
    public String getNombre() {
        return "NOMBRE";
    }
}
