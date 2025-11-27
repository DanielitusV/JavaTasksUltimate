package com.javatasksultimate.access_data;

import com.javatasksultimate.logic_service.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de TaskDAO que guarda las tareas
 * en un archivo JSON simple dentro de la carpeta "storage"
 * Cada línea del archivo es un objeto JSON independiente.
 */

public class JsonTaskDAO implements TaskDAO{
    private static final String FILE_PATH = "storage/tasks.json";

    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public void saveAllTasks(List<Task> tasks) {

    }
}
