package com.javatasksultimate.presentation.commands;

import com.javatasksultimate.logic_service.TaskService;

import java.util.Scanner;

public class AddTaskCommand implements Command {
    private final TaskService taskService;
    private final Scanner reader;

    public AddTaskCommand(TaskService taskService, Scanner reader) {
        this.taskService = taskService;
        this.reader = reader;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("===== INGRESAR TAREA =====\n");
        System.out.print("Ingrese el título de la nueva tarea: ");
        String title = reader.nextLine();

        if (title == null || title.isBlank()) {
            System.out.println("El título no puede estar vacío.");
            return;
        }

        taskService.addTask(title);
        System.out.println("Tarea agregada correctamente");
    }
}
