package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.port.actions.ITodoRepository;
import com.heyrudy.app.exception.DbRequestException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class UpdateTodoUsecase {

    private final ITodoRepository repository;

    public UpdateTodoUsecase(ITodoRepository repository) {
        this.repository = repository;
    }

    public Optional<Todo> execute(final Long id, final Todo todo) {
        repository.getTodoById(id)
                .orElseThrow(
                        () -> new DbRequestException(String.format("todo with id : %d " + "don't exist in Database", id))
                );
        return Optional.ofNullable(repository.updateTodo(todo.withId(id)));
    }
}
