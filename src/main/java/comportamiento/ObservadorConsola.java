/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comportamiento;

import modelo.Tarea;

public class ObservadorConsola implements Observador {
    @Override
    public void actualizar(String evento, Tarea tarea) {
        System.out.println(" * " + evento + ": " + tarea.getDescripcion());
    }
}