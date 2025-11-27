/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comportamiento;

import modelo.Tarea;

public class ObservadorContador implements Observador {
    private int contador = 0;

    @Override
    public void actualizar(String evento, Tarea tarea) {
        contador++;
        System.out.println("Total de eventos: " + contador);
    }
}

