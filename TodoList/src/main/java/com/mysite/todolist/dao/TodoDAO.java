package com.mysite.todolist.dao;

import com.mysite.todolist.entity.Todo;

import java.util.List;

public interface TodoDAO {
    int createTodo(Todo todo);
    Todo updateTodo(Todo todo);
    void deleteTodo(int id);
    List<Todo> getAllTodos();
    List<Todo> getAllTodos(Boolean todoDone);
    Todo getTodo(int id);
}
