package com.heyrudy.core.interactors;

import com.heyrudy.core.entities.Todo;
import com.heyrudy.core.abilities.storage.ITodoRepository;

public final class CreateTodoUsecase {

    private final ITodoRepository repository;

    public CreateTodoUsecase(ITodoRepository repository) {
        this.repository = repository;
    }

    public Todo execute(final Todo todo) {
        return repository.saveTodo(todo);
    }
}
