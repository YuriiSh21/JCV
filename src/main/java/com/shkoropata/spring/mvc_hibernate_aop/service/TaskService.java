package com.shkoropata.spring.mvc_hibernate_aop.service;

import com.shkoropata.spring.mvc_hibernate_aop.entity.Task;

import java.util.List;

public interface TaskService {

    public List<Task> getAllTasks();

    public void saveTask(Task task);

    public Task getTask(int id);

    public void deleteTask(int id);
}
