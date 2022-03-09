package com.heyrudy.aggregates;

import com.heyrudy.aggregates.dto.TodoDto;
import com.heyrudy.core.entities.Todo;
import com.heyrudy.core.interactors.CreateTodoUsecase;
import com.heyrudy.core.interactors.DeleteTodoByIdUsecase;
import com.heyrudy.core.interactors.GetTodoByIdUsecase;
import com.heyrudy.core.interactors.GetTodosUsecase;
import com.heyrudy.core.interactors.UpdateTodoUsecase;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class TodoQuery {

    private final GetTodosUsecase getTodos;
    private final GetTodoByIdUsecase getTodoById;

    public TodoQuery(GetTodosUsecase getTodos,
                     GetTodoByIdUsecase getTodoById) {
        this.getTodos = getTodos;
        this.getTodoById = getTodoById;
    }

    public List<TodoDto> getTodos() {
        return getTodos.execute()
                .stream()
                .map(TodoDto::toTodoDto)
                .collect(Collectors.toList());
    }

    public Optional<TodoDto> getTodoById(final long id) {
        final Optional<Todo> todoOptional = getTodoById.execute(id);
        if (todoOptional.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(TodoDto.toTodoDto(todoOptional.get()));
    }
}
