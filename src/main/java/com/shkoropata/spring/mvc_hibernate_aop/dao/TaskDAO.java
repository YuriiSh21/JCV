package com.shkoropata.spring.mvc_hibernate_aop.dao;

import com.shkoropata.spring.mvc_hibernate_aop.entity.Task;

import java.util.List;

public interface TaskDAO {
    public List<Task> getAllTasks();

    public void saveTask(Task task);

   public Task getTask(int id);

   public void deleteTask(int id);
}
