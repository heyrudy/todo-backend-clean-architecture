package com.heyrudy.app.core.usecases;

import com.heyrudy.app.core.abilities.storage.exception.DbRequestException;
import com.heyrudy.app.core.abilities.storage.ITodoStore;
import org.springframework.stereotype.Component;

@Component
public record DeleteTodoByIdUsecase(ITodoStore store) {

    public void execute(final Long todoID) {
        store.getTodoById(todoID).ifPresentOrElse(todoFound -> store.deleteTodoById(todoFound.getTodoID()), () -> {
            throw new DbRequestException(String.format("todo entity to be deleted with id : %d " + "don't exist in " +
                    "Database", todoID));
        });
    }
}
