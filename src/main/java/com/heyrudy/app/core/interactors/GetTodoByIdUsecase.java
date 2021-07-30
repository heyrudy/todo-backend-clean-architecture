package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.port.actions.ITodoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class GetTodoByIdUsecase {

    private final ITodoRepository repository;

    public GetTodoByIdUsecase(ITodoRepository repository) {
        this.repository = repository;
    }

    public Optional<Todo> execute(final long id) {
        return repository.getTodoById(id);
    }
}
