package com.heyrudy.app.core.interactors;

import com.heyrudy.app.api.exception.DbRequestException;
import com.heyrudy.app.core.abilities.storage.ITodoRepository;
import org.springframework.stereotype.Component;

@Component
public record DeleteTodoByIdUsecase(ITodoRepository repository) {

    public void execute(final Long todoID) {
        repository.getTodoById(todoID).ifPresentOrElse(todoFound -> repository.deleteTodoById(todoFound.getTodoID()), () -> {
            throw new DbRequestException(String.format("todo entity to be deleted with id : %d " + "don't exist in Database", todoID));
        });
    }
}
