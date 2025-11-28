package com.javatasksultimate.access_data;

import java.io.File;
import java.io.IOException;

/**
 * Gestiona la ruta física del archivo de almacenamiento.
 * Se asegura de que exista la carpeta 'storage' y el archivo 'tasks.txt'
 */

public class TaskFileStorage {
    private static final String STORAGE_PATH = "storage/tasks.txt";

    public static File getStorageFile() {
        File file = new File(STORAGE_PATH);
        File parent = file.getParentFile();

        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de tareas: " + e.getMessage());
            }
        }

        return file;
    }
}
