package com.shkoropata.spring.mvc_hibernate_aop.dao;

import com.shkoropata.spring.mvc_hibernate_aop.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Task> getAllTasks() {

        Session session = sessionFactory.getCurrentSession();
        List<Task> allTasks = session.createQuery("from Task", Task.class)
                .getResultList();

        return allTasks;
    }

    @Override
    public void saveTask(Task task) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(task);

    }

    @Override
    public Task getTask(int id) {

        Session session = sessionFactory.getCurrentSession();

        Task task = session.get(Task.class, id);
        return task;
    }

    @Override
    public void deleteTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Task> query = session.createQuery("delete from Task " +
                "where id =:taskId");
        query.setParameter("taskId", id);
        query.executeUpdate();
    }
}
