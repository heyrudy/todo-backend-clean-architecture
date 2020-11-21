package com.heyrudy.app.controller;

import com.heyrudy.app.exception.ApiRequestException;
import com.heyrudy.spring_controller.TodoController;
import com.heyrudy.spring_controller.dto.TodoDto;
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

    private final TodoController controller;

    public SpringTodoController(TodoController controller) {
        this.controller = controller;
    }

    @PostMapping(value = "/todos")
    public TodoDto createTodo(@RequestBody final TodoDto todoDto) {
        return controller.createTodo(todoDto);
    }

    @GetMapping(value = "/todos")
    public List<TodoDto> getTodos() {
        return controller.getTodos();
    }

    @GetMapping(value = "/todos/{todoId}")
    public TodoDto getTodoById(@PathVariable("todoId") final long id) {
        return controller.getTodoById(id)
                .orElseThrow(() -> new ApiRequestException(String.format("todo with %d is not found", id)));
    }

    @PutMapping(value = "/todos/{todoId}")
    public TodoDto updateTodo(@PathVariable("todoId") final long id, @RequestBody final TodoDto todoDto) {
        return controller.updateTodo(id, todoDto)
                .orElseThrow(() -> new ApiRequestException(String.format("todo with %d could not be updated", id)));
    }

    @DeleteMapping(value = "/todos/{todoId}")
    public void deleteTodoById(@PathVariable("todoId") final long id) {
        controller.deleteTodoById(id);
    }
}
