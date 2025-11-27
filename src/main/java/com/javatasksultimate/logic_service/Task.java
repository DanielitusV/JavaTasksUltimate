package main.java.com.javatasksultimate.logic_service;

/**
 * Representa una tarea simple de la lista de pendientes.
 * Aplica el patrón Factory Method a través del método estático create.
 */

public class Task {
    private final String title;
    private boolean completed;

    private Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public static Task create(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("El título de la tarea no puede estar vacío.");
        }
        return new Task(title.trim());
    }

    public void complete() {
        this.completed = true;
    }
    public boolean isCompleted() {
        return completed;
    }
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        String status = completed ? "[X]" : "[ ]";
        return status + " " + title;
    }
}
