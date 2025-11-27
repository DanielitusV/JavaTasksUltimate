package com.javatasksultimate.access_data;

import com.javatasksultimate.logic_service.Task;
import java.util.List;

/**
 * Define las operaciones de acceso a datos para las tareas.
 * Forma parte de la capa de datos usando el patrón DAO.
 */

public interface TaskDAO {
    /*
     * Obtiene todas las tareas almacenadas.
     * @return lista de tareas
     */
    List<Task> getAllTasks();

    /*
     * Guarda el estado completo de la lista de tareas.
     * @param tasks lista de tareas a guardar
     */
    void saveAllTasks(List<Task> tasks);
}
