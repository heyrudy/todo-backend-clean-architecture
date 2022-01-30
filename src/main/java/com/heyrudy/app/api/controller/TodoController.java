package com.heyrudy.app.api.controller;

import com.heyrudy.app.api.exception.ApiRequestException;
import com.heyrudy.app.api.aggregates.TodoCommand;
import com.heyrudy.app.api.aggregates.TodoQuery;
import com.heyrudy.app.api.aggregates.TodoInfos;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public record TodoController(TodoQuery todoQuery, TodoCommand todoCommand) {

    @PostMapping(value = "/todos")
    public void createTodo(@Valid @RequestBody final TodoInfos todoInfos) {
        todoCommand.createTodo(todoInfos.toTodo());
    }

    @GetMapping(value = "/todos")
    public List<TodoInfos> getTodos() {
        return todoQuery.getTodos();
    }

    @GetMapping(value = "/todos/{todoId}")
    public TodoInfos getTodoById(@PathVariable("todoId") final Long id) {
        return todoQuery.getTodoById(id).orElseThrow(() -> new ApiRequestException(String.format("todo entity with id : " +
                "%d is " + "not " + "found", id)));
    }

    @PutMapping(value = "/todos/{todoId}")
    public void updateTodo(@PathVariable("todoId") final Long id, @Valid @RequestBody final TodoInfos todoInfos) {
        todoCommand.updateTodo(id, todoInfos.toTodo());
    }

    @DeleteMapping(value = "/todos/{todoId}")
    public void deleteTodoById(@PathVariable("todoId") final Long id) {
        todoCommand.deleteTodoById(id);
    }
}
