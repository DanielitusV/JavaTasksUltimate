package com.javatasksultimate.presentation;

import com.javatasksultimate.logic_service.TaskService;

import java.util.Scanner;

/**
 * Capa de presentación en consola.
 * Muestra el menú y ejecuta los comandos correspondientes.
 */
public class ConsoleUI {
    private final TaskService taskService;
    private final Scanner reader;

    private final Command addTaskCommand;
    private final Command listTasksCommand;
    private final Command completeTaskCommand;
    private final Command deleteTaskCommand;

    public ConsoleUI(TaskService taskService) {
        this.taskService = taskService;
        this.reader = new Scanner(System.in);

        this.addTaskCommand = new AddTaskCommand(taskService, reader);
        this.listTasksCommand = new ListTasksCommand(taskService, reader);
        this.completeTaskCommand = new CompleteTaskCommand(taskService, reader);
        this.deleteTaskCommand = new DeleteTaskCommand(taskService, reader);
    }

    public void start() {
        boolean running = true;

        System.out.println("=== JavaTaskUltimate ===");

        while (running) {
            printMenu();
            String option = reader.nextLine();

            switch (option) {
                case "1":
                    addTaskCommand.execute();
                    break;
                case "2":
                    listTasksCommand.execute();
                    break;
                case "3":
                    completeTaskCommand.execute();
                    break;
                case "4":
                    deleteTaskCommand.execute();
                    break;
                case "5":
                    running = false;
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("===== MENÚ PRINCIPAL =====");
        System.out.println("1. Crear tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
