/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comportamiento;

import modelo.Tarea;

/**
 * Interfaz Observador del patrón Observer.
 */
public interface Observador {
    void actualizar(String evento, Tarea tarea);
}
