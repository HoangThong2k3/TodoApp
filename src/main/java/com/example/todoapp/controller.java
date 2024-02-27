package com.example.todoapp;

import Entity.ToDoEntity;
import TodoRepository.TodoRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/todoList")
public class controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TodoRepository todoRepository = new TodoRepository();
        List<ToDoEntity> todoList = todoRepository.getAllToDos();

        request.setAttribute("todoList", todoList);
        request.getRequestDispatcher("/todoList.jsp").forward(request, response);
    }
}

