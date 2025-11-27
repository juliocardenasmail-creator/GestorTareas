/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comportamiento;

import modelo.Tarea;
import java.util.Comparator;

/**
 * Strategy para ordenamiento de tareas.
 */
public interface OrdenamientoStrategy extends Comparator<Tarea> {
    String getNombre();
}
