package com.heyrudy.aggregates;

import com.heyrudy.aggregates.dto.TodoDto;
import com.heyrudy.core.entities.Todo;
import com.heyrudy.core.interactors.*;

import java.util.Optional;

public final class TodoCommand {

    private final CreateTodoUsecase createTodo;
    private final UpdateTodoUsecase updateTodo;
    private final DeleteTodoByIdUsecase deleteTodoById;

    public TodoCommand(CreateTodoUsecase createTodo, UpdateTodoUsecase updateTodo,
                       DeleteTodoByIdUsecase deleteTodoById) {
        this.createTodo = createTodo;
        this.updateTodo = updateTodo;
        this.deleteTodoById = deleteTodoById;
    }

    public TodoDto createTodo(final TodoDto todoDto) {
        Todo todo = todoDto.toTodo();
        return TodoDto.toTodoDto(createTodo.execute(todo));
    }

    public Optional<TodoDto> updateTodo(final long id, final TodoDto todoDto) {
        Todo todo = todoDto.toTodo();
        final Optional<Todo> todoOptional = updateTodo.execute(id, todo);
        if (todoOptional.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(TodoDto.toTodoDto(todoOptional.get()));
    }

    public void deleteTodoById(final long id) {
        deleteTodoById.execute(id);
    }
}
