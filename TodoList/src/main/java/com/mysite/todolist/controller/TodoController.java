package com.mysite.todolist.controller;

import com.mysite.todolist.entity.Todo;
import com.mysite.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class TodoController {

    public TodoController() {
    }

    @Autowired
    private TodoService todoService;

    @RequestMapping("createTodo")
    public ModelAndView createTodo(@ModelAttribute Todo todo) {
        return new ModelAndView("todoForm");
    }

    @RequestMapping("editTodo")
    public ModelAndView editTodo(@RequestParam int id, @ModelAttribute Todo todo) {
        todo = todoService.getTodo(id);
        return new ModelAndView("todoFormUpdate", "todoObject", todo);
    }

    @RequestMapping("saveTodo")
    public ModelAndView saveTodo(@ModelAttribute Todo todo) {
        if (todo.getId() == 0) {
            todoService.createTodo(todo);
        } else {
            todoService.updateTodo(todo);
        }
        return new ModelAndView("redirect:getAllTodos");
    }

    @RequestMapping("deleteTodo")
    public ModelAndView deleteTodo(@RequestParam int id) {
        todoService.deleteTodo(id);
        return new ModelAndView("redirect:getAllTodos");
    }

    @RequestMapping(value = {"getAllTodos", "/"})
    public ModelAndView getAllTodos() {
        ModelAndView modelAndView = new ModelAndView("todoList");
        List<Todo> todoList = todoService.getAllTodos();
        modelAndView.addObject("todoList", todoList);
        return modelAndView;
    }

    @RequestMapping("searchTodo")
    public ModelAndView searchTodo(@RequestParam(value = "searchIsDone") Boolean searchIsDone) {
        ModelAndView modelAndView = new ModelAndView("searchTodo");
        List<Todo> todoList = todoService.getAllTodos(searchIsDone);
        modelAndView.addObject("todoList", todoList);
        modelAndView.addObject("searchIsDone", searchIsDone);
        return modelAndView;
    }
}