package com.heyrudy.app.aggregates;

import com.heyrudy.app.core.interactors.GetTodoByIdUsecase;
import com.heyrudy.app.core.interactors.GetTodosUsecase;
import com.heyrudy.app.aggregates.dto.TodoDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public final class TodoQuery {

    private final GetTodosUsecase getTodos;
    private final GetTodoByIdUsecase getTodoById;

    public TodoQuery(GetTodosUsecase getTodos, GetTodoByIdUsecase getTodoById) {
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
        return getTodoById.execute(id)
                .map(TodoDto::toTodoDto);
    }
}
