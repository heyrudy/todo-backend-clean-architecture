package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.abilities.storage.ITodoRepository;
import com.heyrudy.app.core.entities.Todo;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public record GetTodoByIdUsecase(ITodoRepository repository) {

    public Optional<Todo> execute(final Long todoID) {
        return repository.getTodoById(todoID);
    }
}
