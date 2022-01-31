package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.abilities.storage.ITodoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public record GetTodoByIdUsecase(ITodoRepository repository) {

    public Optional<Todo> execute(final Long id) {
        return repository.getTodoById(id);
    }
}
