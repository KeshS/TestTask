package com.mysite.todolist.dao;

import com.mysite.todolist.entity.Todo;
import com.mysite.todolist.utils.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class TodoDAOImpl implements TodoDAO {
    public TodoDAOImpl() {
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public int createTodo(Todo todo) {
        return (Integer) hibernateUtil.create(todo);
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return hibernateUtil.update(todo);
    }

    @Override
    public void deleteTodo(int id) {
        Todo todo = new Todo();
        todo.setId(id);
        hibernateUtil.delete(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return hibernateUtil.fetchAll(Todo.class);
    }

    @Override
    public Todo getTodo(int id) {
        return hibernateUtil.fetchById(id, Todo.class);
    }

    @Override
    public List<Todo> getAllTodos(Boolean todoDone) {
        List<Todo> filtered = new ArrayList<>();
        if (todoDone == null) {
            return getAllTodos();
        } else if (todoDone == false) {
            for (Todo todo : getAllTodos()) {
                if (todo.getDone() == false) {
                    filtered.add(todo);
                }
            }
        } else if (todoDone) {
            for (Todo todo : getAllTodos()) {
                if (todo.getDone() == true) {
                    filtered.add(todo);
                }
            }
        }
        return filtered;
    }
}
