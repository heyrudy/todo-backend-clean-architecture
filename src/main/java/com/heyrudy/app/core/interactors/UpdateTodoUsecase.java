package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.port.actions.ITodoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
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
