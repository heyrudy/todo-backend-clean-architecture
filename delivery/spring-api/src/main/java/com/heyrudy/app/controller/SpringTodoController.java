package com.heyrudy.app.controller;

import com.heyrudy.aggregates.TodoQuery;
import com.heyrudy.app.exception.ApiRequestException;
import com.heyrudy.aggregates.TodoCommand;
import com.heyrudy.aggregates.dto.TodoDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class SpringTodoController {

    private final TodoCommand todoCommand;
    private final TodoQuery todoQuery;

    public SpringTodoController(TodoCommand todoCommand,
                                TodoQuery todoQuery) {
        this.todoCommand = todoCommand;
        this.todoQuery = todoQuery;
    }

    @PostMapping(value = "/todos")
    public TodoDto createTodo(@RequestBody final TodoDto todoDto) {
        return todoCommand.createTodo(todoDto);
    }

    @GetMapping(value = "/todos")
    public List<TodoDto> getTodos() {
        return todoQuery.getTodos();
    }

    @GetMapping(value = "/todos/{todoId}")
    public TodoDto getTodoById(@PathVariable("todoId") final long id) {
        return todoQuery.getTodoById(id)
                .orElseThrow(() -> new ApiRequestException(String.format("todo with %d is not found", id)));
    }

    @PutMapping(value = "/todos/{todoId}")
    public TodoDto updateTodo(@PathVariable("todoId") final long id, @RequestBody final TodoDto todoDto) {
        return todoCommand.updateTodo(id, todoDto)
                .orElseThrow(() -> new ApiRequestException(String.format("todo with %d could not be updated", id)));
    }

    @DeleteMapping(value = "/todos/{todoId}")
    public void deleteTodoById(@PathVariable("todoId") final long id) {
        todoCommand.deleteTodoById(id);
    }
}
