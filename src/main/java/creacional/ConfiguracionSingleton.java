/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creacional;

/**
 * Singleton para configuración de la aplicación.
 * Responsable única de valores de configuración.
 */
public class ConfiguracionSingleton {
    private static ConfiguracionSingleton instancia;
    private String nombreUsuario;
    private boolean notificacionesActivas;
    private String rutaArchivo;

    private ConfiguracionSingleton() {
        this.nombreUsuario = "Usuario";
        this.notificacionesActivas = true;
        this.rutaArchivo = "tareas.txt";
    }

    public static synchronized ConfiguracionSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionSingleton();
        }
        return instancia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombre) {
        this.nombreUsuario = nombre;
    }

    public boolean isNotificacionesActivas() {
        return notificacionesActivas;
    }

    public void setNotificacionesActivas(boolean activas) {
        this.notificacionesActivas = activas;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String ruta) {
        this.rutaArchivo = ruta;
    }
}
