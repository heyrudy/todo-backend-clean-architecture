package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.port.actions.ITodoRepository;
import org.springframework.stereotype.Component;

@Component
public final class DeleteTodoByIdUsecase {

    private final ITodoRepository repository;

    public DeleteTodoByIdUsecase(ITodoRepository repository) {
        this.repository = repository;
    }

    public void execute(final long id) {
        repository.deleteTodoById(id);
    }
}
