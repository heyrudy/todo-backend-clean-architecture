package com.heyrudy.core.interactors;

import com.heyrudy.core.entities.Todo;
import com.heyrudy.core.abilities.storage.ITodoRepository;

import java.util.Optional;

public final class GetTodoByIdUsecase {

    private final ITodoRepository repository;

    public GetTodoByIdUsecase(ITodoRepository repository) {
        this.repository = repository;
    }

    public Optional<Todo> execute(final Long id) {
        return repository.getTodoById(id);
    }
}
