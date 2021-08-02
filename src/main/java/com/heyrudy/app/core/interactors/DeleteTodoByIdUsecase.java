package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.port.actions.ITodoRepository;
import com.heyrudy.app.exception.DbRequestException;
import org.springframework.stereotype.Component;

@Component
public final class DeleteTodoByIdUsecase {

    private final ITodoRepository repository;

    public DeleteTodoByIdUsecase(ITodoRepository repository) {
        this.repository = repository;
    }

    public void execute(final Long id) {
        if(repository.getTodoById(id).isEmpty())
            throw new DbRequestException(String.format("todo with id : %d " + "don't exist in Database", id));
        repository.deleteTodoById(id);
    }
}
