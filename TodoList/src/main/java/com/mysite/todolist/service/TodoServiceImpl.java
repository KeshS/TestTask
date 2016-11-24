package com.mysite.todolist.service;

import com.mysite.todolist.dao.TodoDAO;
import com.mysite.todolist.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    public TodoServiceImpl() {

    }

    @Autowired
    private TodoDAO todoDAO;

    @Override
    public int createTodo(Todo todo) {
        return todoDAO.createTodo(todo);
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return todoDAO.updateTodo(todo);
    }

    @Override
    public void deleteTodo(int id) {
        todoDAO.deleteTodo(id);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoDAO.getAllTodos();
    }

    @Override
    public Todo getTodo(int id) {
        return todoDAO.getTodo(id);
    }

    @Override
    public List<Todo> getAllTodos(Boolean todoDone) {
        return todoDAO.getAllTodos(todoDone);
    }
}
