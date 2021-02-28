package com.heyrudy.app.controller;

import com.heyrudy.app.exception.ApiRequestException;
import com.heyrudy.app.router.TodoRouter;
import com.heyrudy.app.router.dto.TodoDto;
import org.springframework.web.bind.annotation.*;

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
        return router.createTodo(todoDto);
    }

    @GetMapping(value = "/todos")
    public List<TodoDto> getTodos() {
        return router.getTodos();
    }

    @GetMapping(value = "/todos/{todoId}")
    public TodoDto getTodoById(@PathVariable("todoId") final long id) {
        return router.getTodoById(id)
                .orElseThrow(
                        () -> new ApiRequestException(String.format("todo with %d is not " + "found", id))
                );
    }

    @PutMapping(value = "/todos/{todoId}")
    public TodoDto updateTodo(@PathVariable("todoId") final long id, @Valid @RequestBody final TodoDto todoDto) {
        return router.updateTodo(id, todoDto)
                .orElseThrow(
                        () -> new ApiRequestException(String.format("todo with %d " + "could not be updated", id))
                );
    }

    @DeleteMapping(value = "/todos/{todoId}")
    public void deleteTodoById(@PathVariable("todoId") final long id) {
        router.deleteTodoById(id);
    }
}
