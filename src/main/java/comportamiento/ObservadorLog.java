/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comportamiento;

import modelo.Tarea;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ObservadorLog implements Observador {
    private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public void actualizar(String evento, Tarea tarea) {
        String log = String.format("[%s] %s - Tarea: %s", LocalDateTime.now().format(formato), evento, tarea.getId());
        System.out.println("LOG: " + log);
    }
}
