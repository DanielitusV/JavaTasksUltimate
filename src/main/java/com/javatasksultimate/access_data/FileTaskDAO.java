package com.javatasksultimate.access_data;

import com.javatasksultimate.logic_service.Task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa TaskDAO usando un archivo de texto simple.
 * Cada línea tiene el formato: título;0/1 (0 = pendiente, 1 = completada).
 */

public class FileTaskDAO implements TaskDAO{

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = TaskFileStorage.getStorageFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;

                String[] parts = line.split(";", 2);
                String title = parts[0];
                boolean completed = parts.length > 1 && "1".equals(parts[1]);

                Task task = Task.create(title);
                if (completed) {
                    task.complete();
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Error al leer tareas: " + e.getMessage());
        }
        return tasks;
    }

    @Override
    public void saveAllTasks(List<Task> tasks) {
        File file = TaskFileStorage.getStorageFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Task t : tasks) {
                String status = t.isCompleted() ? "1" : "0";
                writer.write(t.getTitle() + ";" + status);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar tareas: " + e.getMessage());
        }
    }
}
