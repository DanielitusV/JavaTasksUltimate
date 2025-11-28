package com.javatasksultimate;

import com.javatasksultimate.access_data.FileTaskDAO;
import com.javatasksultimate.access_data.TaskDAO;
import com.javatasksultimate.logic_service.TaskService;
import com.javatasksultimate.logic_service.TaskServiceImpl;
import com.javatasksultimate.presentation.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        TaskDAO taskDAO = new FileTaskDAO();
        TaskService taskService = new TaskServiceImpl(taskDAO);
        ConsoleUI consoleUI = new ConsoleUI(taskService);

        consoleUI.start();
    }
}
