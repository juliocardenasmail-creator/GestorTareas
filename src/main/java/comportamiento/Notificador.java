/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comportamiento;

import java.util.ArrayList;
import java.util.List;

/**
 * Objeto que gestiona los observadores y notificaciones.
 * (Es la "Subject" en el patrón Observer)
 */
public class Notificador {
    private final List<Observador> observadores = new ArrayList<>();

    public void agregar(Observador obs) {
        if (obs != null) {
            observadores.add(obs);
        }
    }

    public void notificar(String evento, modelo.Tarea tarea) {
        for (Observador obs : new ArrayList<>(observadores)) {
            obs.actualizar(evento, tarea);
        }
    }
}