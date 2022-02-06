package com.heyrudy.app.api.aggregates;

import com.heyrudy.app.core.interactors.GetTodoByIdUsecase;
import com.heyrudy.app.core.interactors.GetTodosUsecase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public record TodoQuery(GetTodosUsecase getTodosUsecase, GetTodoByIdUsecase getTodoByIdUsecase) {

    public List<TodoInfos> getTodos() {
        return getTodosUsecase.execute().stream().map(TodoInfos::toTodoInfos).toList();
    }

    public Optional<TodoInfos> getTodoById(final Long todoID) {
        return getTodoByIdUsecase.execute(todoID).map(TodoInfos::toTodoInfos);
    }
}
