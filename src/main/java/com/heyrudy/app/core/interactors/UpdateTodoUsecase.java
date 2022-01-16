package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.port.actions.ITodoRepository;
import com.heyrudy.app.exception.DbRequestException;
import org.springframework.stereotype.Component;

@Component
public final class UpdateTodoUsecase {

    private final ITodoRepository repository;

    public UpdateTodoUsecase(ITodoRepository repository) {
        this.repository = repository;
    }

    public void execute(final Long id, final Todo todo) {
        repository.getTodoById(id).ifPresentOrElse(todoFound -> repository.updateTodo(todo.withId(todoFound.getTodoID())), () -> {
            throw new DbRequestException(String.format("todo entity to be updated with id : %d " + "don't exist in Database", id));
        });
    }
}
