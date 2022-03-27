package com.heyrudy.app.core.usecases;

import com.heyrudy.app.core.abilities.storage.exception.DbRequestException;
import com.heyrudy.app.core.abilities.storage.ITodoStore;
import com.heyrudy.app.core.states.Todo;
import org.springframework.stereotype.Component;

@Component
public record UpdateTodoUsecase(ITodoStore store) {

    public void execute(final Long todoID, final Todo todo) {
        store.getTodoById(todoID).ifPresentOrElse(todoFound -> store.updateTodo(todo.withId(todoFound.getTodoID())),
                () -> {
            throw new DbRequestException(String.format("todo entity to be updated with id : %d " + "don't exist in " +
                    "Database", todoID));
        });
    }
}
