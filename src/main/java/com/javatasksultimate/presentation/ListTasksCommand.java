package com.javatasksultimate.presentation;

import com.javatasksultimate.logic_service.Task;
import com.javatasksultimate.logic_service.TaskService;

import java.util.List;
import java.util.Scanner;

public class ListTasksCommand implements Command {
    private final TaskService taskService;
    private final Scanner reader;

    public ListTasksCommand(TaskService taskService, Scanner reader) {
        this.taskService = taskService;
        this.reader = reader;
    }

    @Override
    public void execute() {
        List<Task> tasks = taskService.getAllTasks();

        System.out.println();
        System.out.println("===== LISTA DE TAREAS =====");

        if (tasks.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + "." + task);
            }
        }
        System.out.println();
        System.out.println("Presione Enter para volver al menú...");
        reader.nextLine();
    }
}
