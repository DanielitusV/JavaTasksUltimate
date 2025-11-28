package com.javatasksultimate.logic_service;

import com.javatasksultimate.access_data.TaskDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de TaskService.
 * Aplica SOLID al separar la lógica de negocio del acceso a datos (DAO).
 */
public class TaskServiceImpl implements TaskService {
    private final TaskDAO taskDAO;

    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public void addTask(String title) {
        List<Task> tasks = getSafeTasks();
        Task newTask = Task.create(title);
        tasks.add(newTask);
        taskDAO.saveAllTasks(tasks);
    }

    @Override
    public List<Task> getAllTasks() {
        return getSafeTasks();
    }

    @Override
    public boolean completeTask(int index) {
        List<Task> tasks = getSafeTasks();
        if (index < 0 || index >= tasks.size()) {
            return false;
        }
        Task task = tasks.get(index);
        task.complete();
        taskDAO.saveAllTasks(tasks);
        return true;
    }

    @Override
    public boolean deleteTask(int index) {
        List<Task> tasks = getSafeTasks();
        if (index < 0 || index >= tasks.size()) {
            return false;
        }
        tasks.remove(index);
        taskDAO.saveAllTasks(tasks);
        return true;
    }

    @Override
    public boolean hasTasks() {
        return !getSafeTasks().isEmpty();
    }

    // Método interno para evitar nulls y simplificar el código.
    private List<Task> getSafeTasks() {
        List<Task> tasks = taskDAO.getAllTasks();
        if (tasks == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(tasks);
    }
}
