package com.heyrudy.core.interactors;

import com.heyrudy.core.entities.Todo;
import com.heyrudy.core.abilities.storage.ITodoRepository;

import java.util.Optional;

public final class UpdateTodoUsecase {

    private final ITodoRepository repository;

    public UpdateTodoUsecase(ITodoRepository repository) {
        this.repository = repository;
    }

    public Optional<Todo> execute(final long id, final Todo todo) {
        if (repository.getTodoById(id).isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(repository.updateTodo(todo));
    }
}
