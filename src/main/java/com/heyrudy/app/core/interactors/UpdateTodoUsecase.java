package com.heyrudy.app.core.interactors;

import com.heyrudy.app.api.exception.DbRequestException;
import com.heyrudy.app.core.abilities.storage.ITodoRepository;
import com.heyrudy.app.core.entities.Todo;
import org.springframework.stereotype.Component;

@Component
public record UpdateTodoUsecase(ITodoRepository repository) {

    public void execute(final Long todoID, final Todo todo) {
        repository.getTodoById(todoID).ifPresentOrElse(todoFound -> repository.updateTodo(todo.withId(todoFound.getTodoID())), () -> {
            throw new DbRequestException(String.format("todo entity to be updated with id : %d " + "don't exist in Database", todoID));
        });
    }
}
