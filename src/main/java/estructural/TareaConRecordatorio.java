/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructural;

import modelo.Tarea;
import java.time.LocalDate;

public class TareaConRecordatorio extends TareaDecorator {
    private final LocalDate fechaRecordatorio;

    public TareaConRecordatorio(Tarea tarea, LocalDate fechaRecordatorio) {
        super(tarea);
        this.fechaRecordatorio = fechaRecordatorio;
    }

    @Override
    public String toString() {
        return tareaBase.toString() + " * " + fechaRecordatorio;
    }
}
