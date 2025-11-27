/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import modelo.Tarea;
import creacional.TareaFactory;
import comportamiento.OrdenamientoStrategy;
import comportamiento.OrdenarPorFecha;
import comportamiento.OrdenarPorNombre;
import comportamiento.OrdenarPorPrioridad;
import comportamiento.Observador;
import comportamiento.Notificador;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Repositorio responsable de persistencia y manejo en memoria de tareas.
 * Sigue Single Responsibility: solo persistencia/colección.
 */
public class TareaRepositorio {
    private final List<Tarea> tareas;
    private OrdenamientoStrategy estrategia;
    private final Notificador notificador;

    public TareaRepositorio() {
        this.tareas = new ArrayList<>();
        this.estrategia = new OrdenarPorFecha();
        this.notificador = new Notificador();
    }

    public void agregarObservador(Observador obs) {
        notificador.agregar(obs);
    }

    public void setEstrategiaOrdenamiento(OrdenamientoStrategy estrategia) {
        if (estrategia != null) {
            this.estrategia = estrategia;
            Collections.sort(tareas, this.estrategia);
        }
    }

    public void cambiarOrdenamiento(String tipo) {
        if (tipo == null) tipo = "";
        switch (tipo.toUpperCase()) {
            case "PRIORIDAD":
                this.estrategia = new OrdenarPorPrioridad();
                break;
            case "NOMBRE":
                this.estrategia = new OrdenarPorNombre();
                break;
            default:
                 this.estrategia = new OrdenarPorFecha();
        }
        Collections.sort(tareas, estrategia);
    }

    public void agregar(Tarea tarea) {
        if (tarea == null) return;
        tareas.add(tarea);
        Collections.sort(tareas, estrategia);
        notificador.notificar("TAREA CREADA", tarea);
    }

    public void eliminar(String id) {
        Tarea tarea = buscarPorId(id);
        if (tarea != null) {
            tareas.remove(tarea);
            notificador.notificar("TAREA ELIMINADA", tarea);
        }
    }

    public void completarTarea(String id) {
        Tarea tarea = buscarPorId(id);
        if (tarea != null && !tarea.isCompletada()) {
            tarea.setCompletada(true);
            notificador.notificar("TAREA COMPLETADA", tarea);
        }
    }

    public Tarea buscarPorId(String id) {
        if (id == null) return null;
        return tareas.stream()
                .filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
    }

    public List<Tarea> listar() {
        return Collections.unmodifiableList(new ArrayList<>(tareas));
    }

    public void guardar(String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (Tarea t : tareas) {
                writer.println(t.toFileFormat());
            }
            System.out.println("✅ Tareas guardadas en " + archivo);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar: " + e.getMessage());
        }
    }

    public void cargar(String archivo) {
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            tareas.clear();
            TareaFactory.reiniciarContador();
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length >= 5) {
                    String id = datos[0];
                    String descripcion = datos[1];
                    LocalDate fecha = null;
                    try {
                        fecha = LocalDate.parse(datos[2]);
                    } catch (DateTimeParseException ex) {
                        fecha = LocalDate.now();
                    }
                    boolean completada = Boolean.parseBoolean(datos[3]);
                    int prioridad = 1;
                    try {
                        prioridad = Integer.parseInt(datos[4]);
                    } catch (NumberFormatException ex) {
                        prioridad = 1;
                    }

                    Tarea t = TareaFactory.crearTareaDesdeArchivo(id, descripcion, fecha, completada, prioridad);
                    tareas.add(t);
                }
            }
            Collections.sort(tareas, estrategia);
            System.out.println("✅ " + tareas.size() + " tareas cargadas");
        } catch (IOException e) {
            System.out.println("❌ Error al cargar: " + e.getMessage());
        }
    }
}