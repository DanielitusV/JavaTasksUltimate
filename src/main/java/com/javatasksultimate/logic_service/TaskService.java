package com.javatasksultimate.logic_service;

import java.util.List;

/**
 * Define las operaciones de negocio sobre las tareas.
 * Usa Task como modelo y será implementado por una clase de servicio.
 * La capa de presentación hablará con TaskService, no con el DAO directo.
 */

public interface TaskService {
    /*
     * Crea y guarda una nueva tarea con el título indicado.
     */
    void addTask(String title);

    /*
     * Devuelve la lista actual de tareas.
     */
    List<Task> getAllTasks();

    /*
     * Marca como completada la tarea en la posición indicada.
     * @param index posición de la tarea (0-based).
     */
    boolean completeTask(int index);

    /*
     * Elimina la tarea en la posición indicada.
     * @param index posición de la tarea (0-based).
     */
    boolean deleteTask(int index);

    /*
     * Indica si hay tareas registradas.
     */
    boolean hasTasks();
}
