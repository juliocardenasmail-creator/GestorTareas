/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructural;

import modelo.Tarea;
import creacional.TareaFactory;
import creacional.ConfiguracionSingleton;
import datos.TareaRepositorio;
import comportamiento.Observador;

import java.util.List;

/**
 * Facade que simplifica uso del subsistema.
 */
public class SistemaFacade {
    private final TareaRepositorio repositorio;
    private final ConfiguracionSingleton config;

    public SistemaFacade() {
        this.repositorio = new TareaRepositorio();
        this.config = ConfiguracionSingleton.getInstancia();
        // estrategia por defecto (queda en repositorio)
    }

    public void agregarObservador(Observador obs) {
        repositorio.agregarObservador(obs);
    }

    public void crearTareaNormal(String descripcion) {
        Tarea tarea = TareaFactory.crearTareaNormal(descripcion);
        repositorio.agregar(tarea);
    }

    public void crearTareaPrioritaria(String descripcion, int prioridad) {
        Tarea tarea = TareaFactory.crearTareaPrioritaria(descripcion, prioridad);
        repositorio.agregar(tarea);
    }

    public void completarTarea(String id) {
        repositorio.completarTarea(id);
    }

    public void eliminarTarea(String id) {
        repositorio.eliminar(id);
    }

    public List<Tarea> listarTareas() {
        return repositorio.listar();
    }

    public void guardarTareas() {
        repositorio.guardar(config.getRutaArchivo());
    }

    public void cargarTareas() {
        repositorio.cargar(config.getRutaArchivo());
    }

    public void cambiarOrdenamiento(String tipo) {
        repositorio.cambiarOrdenamiento(tipo);
    }

    public String getNombreUsuario() {
        return config.getNombreUsuario();
    }
}