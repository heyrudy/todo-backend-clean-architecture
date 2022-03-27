package com.heyrudy.app.core.usecases;

import com.heyrudy.app.core.abilities.storage.ITodoStore;
import com.heyrudy.app.core.states.Todo;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public record GetTodoByIdUsecase(ITodoStore store) {

    public Optional<Todo> execute(final Long todoID) {
        return store.getTodoById(todoID);
    }
}
