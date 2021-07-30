package com.heyrudy.app.controller;

import com.heyrudy.app.exception.ApiRequestException;
import com.heyrudy.app.router.TodoRouter;
import com.heyrudy.app.router.dto.TodoDto;
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
public final class TodoController {

    private final TodoRouter router;

    public TodoController(TodoRouter router) {
        this.router = router;
    }

    @PostMapping(value = "/todos")
    public TodoDto createTodo(@Valid @RequestBody final TodoDto todoDto) {
        return router.createTodo(todoDto.toTodo());
    }

    @GetMapping(value = "/todos")
    public List<TodoDto> getTodos() {
        return router.getTodos();
    }

    @GetMapping(value = "/todos/{todoId}")
    public TodoDto getTodoById(@PathVariable("todoId") final long id) {
        return router.getTodoById(id)
                .orElseThrow(
                        () -> new ApiRequestException(String.format("todo with id : %d is not " + "found", id))
                );
    }

    @PutMapping(value = "/todos/{todoId}")
    public TodoDto updateTodo(@PathVariable("todoId") final long id, @Valid @RequestBody final TodoDto todoDto) {
        return router.updateTodo(id, todoDto.toTodo())
                .orElseThrow(
                        () -> new ApiRequestException(String.format("todo with id : %d " + "could not be updated", id))
                );
    }

    @DeleteMapping(value = "/todos/{todoId}")
    public void deleteTodoById(@PathVariable("todoId") final long id) {
        router.deleteTodoById(id);
    }
}
