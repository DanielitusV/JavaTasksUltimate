package com.javatasksultimate.presentation.commands;

import com.javatasksultimate.logic_service.Task;
import com.javatasksultimate.logic_service.TaskService;

import java.util.List;
import java.util.Scanner;

public class DeleteTaskCommand implements Command {
    private final TaskService taskService;
    private final Scanner reader;

    public DeleteTaskCommand(TaskService taskService, Scanner reader) {
        this.taskService = taskService;
        this.reader = reader;
    }

    @Override
    public void execute() {
        List<Task> tasks = taskService.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("No hay tareas para eliminar.");
            return;
        }

        System.out.println();
        System.out.println("===== ELIMINAR TAREA =====");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task);
        }

        System.out.print("Ingresa el número de la tarea a eliminar: ");
        String input = reader.nextLine();

        try {
            int number = Integer.parseInt(input);
            int index = number - 1;

            boolean ok = taskService.deleteTask(index);
            if (ok) {
                System.out.println("Tarea eliminada correctamente.");
            } else {
                System.out.println("Número de tarea inválido.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ser un número");
        }
    }
}
