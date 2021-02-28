package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.port.actions.ITodoRepository;
import org.springframework.stereotype.Component;

@Component
public final class CreateTodoUsecase {

    private final ITodoRepository repository;

    public CreateTodoUsecase(ITodoRepository repository) {
        this.repository = repository;
    }

    public Todo execute(final Todo todo) {
        return repository.saveTodo(todo);
    }
}
