package com.heyrudy.app.api.aggregates;

import com.heyrudy.app.core.interactors.GetTodoByIdUsecase;
import com.heyrudy.app.core.interactors.GetTodosUsecase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public final class TodoQuery {

    private final GetTodosUsecase getTodos;
    private final GetTodoByIdUsecase getTodoById;

    public TodoQuery(GetTodosUsecase getTodos, GetTodoByIdUsecase getTodoById) {
        this.getTodos = getTodos;
        this.getTodoById = getTodoById;
    }

    public List<TodoInfos> getTodos() {
        return getTodos.execute().stream().map(TodoInfos::toTodoInfos).toList();
    }

    public Optional<TodoInfos> getTodoById(final Long id) {
        return getTodoById.execute(id).map(TodoInfos::toTodoInfos);
    }
}
