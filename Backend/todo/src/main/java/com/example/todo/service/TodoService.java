package com.example.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.Todo;
import com.example.todo
.repository.TodoRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;


    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }


    public  Todo updateTodo(Long id, Todo todo) {
        Todo actualTodo = todoRepository.findById(id).orElseThrow();
        actualTodo.setTitle(todo.getTitle());
        actualTodo.setCompleted(todo.isCompleted());
        return todoRepository.save(actualTodo);
    }

    public void deleteTodoByid(Long id){
        todoRepository.deleteById(id);
    }

}
