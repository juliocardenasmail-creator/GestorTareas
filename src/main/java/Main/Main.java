/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import estructural.SistemaFacade;
import comportamiento.ObservadorConsola;
import comportamiento.ObservadorLog;
import comportamiento.ObservadorContador;
import modelo.Tarea;

import java.util.Scanner;
import java.util.List;

public class Main {
    private static SistemaFacade sistema;
    private static Scanner scanner;

    public static void main(String[] args) {
        sistema = new SistemaFacade();
        scanner = new Scanner(System.in);

        // Agregar observadores
        sistema.agregarObservador(new ObservadorConsola());
        sistema.agregarObservador(new ObservadorLog());
        sistema.agregarObservador(new ObservadorContador());

        // Cargar tareas existentes
        sistema.cargarTareas();

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    crearTarea();
                    break;
                case 2:
                    listarTareas();
                    break;
                case 3:
                    completarTarea();
                    break;
                case 4:
                    eliminarTarea();
                    break;
                case 5:
                    cambiarOrdenamiento();
                    break;
                case 6:
                    sistema.guardarTareas();
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion inválida");
            }
        }
        System.out.println("\n¡Hasta luego, " + sistema.getNombreUsuario() + "!");
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("SISTEMA DE GESTION DE TAREAS");
        System.out.println("=".repeat(50));
        System.out.println("1. Crear tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Cambiar ordenamiento");
        System.out.println("6. Guardar y salir");
        System.out.print("\nSeleccione opcion: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void crearTarea() {
        System.out.print("\nDescripcion: ");
        String desc = scanner.nextLine().trim();
        if (desc.isEmpty()) {
            System.out.println("Descripcion vacía, operacion cancelada.");
            return;
        }

        System.out.print("¿Es prioritaria? (s/n): ");
        String esPrioritaria = scanner.nextLine();
        if (esPrioritaria.equalsIgnoreCase("s")) {
            System.out.print("Prioridad (1-5): ");
            try {
                int prioridad = Integer.parseInt(scanner.nextLine());
                sistema.crearTareaPrioritaria(desc, prioridad);
            } catch (NumberFormatException e) {
                System.out.println("Prioridad invalida, creando tarea normal");
                sistema.crearTareaNormal(desc);
            }
        } else {
            sistema.crearTareaNormal(desc);
        }
    }

    private static void listarTareas() {
        System.out.println("\nLISTA DE TAREAS:");
        System.out.println("-".repeat(50));
        List<Tarea> tareas = sistema.listarTareas();
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas");
        } else {
            for (Tarea t : tareas) {
                System.out.println(t);
            }
        }
    }

    private static void completarTarea() {
        System.out.print("\nID de la tarea: ");
        String id = scanner.nextLine();
        sistema.completarTarea(id);
    }

    private static void eliminarTarea() {
        System.out.print("\n️ ID de la tarea: ");
        String id = scanner.nextLine();
        sistema.eliminarTarea(id);
    }

    private static void cambiarOrdenamiento() {
        System.out.println("\nOrdenar por:");
        System.out.println("1.Fecha");
        System.out.println("2.Prioridad");
        System.out.println("3.Nombre");
        System.out.print("Opción: ");
        int opcion = leerOpcion();
        String tipo = switch (opcion) {
            case 2 -> "PRIORIDAD";
            case 3 -> "NOMBRE";
            default -> "FECHA";
        };
        sistema.cambiarOrdenamiento(tipo);
        System.out.println("Ordenamiento cambiado a: " + tipo);
    }
}
