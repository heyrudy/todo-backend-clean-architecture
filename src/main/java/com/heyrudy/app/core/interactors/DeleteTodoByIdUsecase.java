package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.abilities.storage.ITodoRepository;
import com.heyrudy.app.api.exception.DbRequestException;
import org.springframework.stereotype.Component;

@Component
public record DeleteTodoByIdUsecase(ITodoRepository repository) {

    public void execute(final Long id) {
        repository.getTodoById(id).ifPresentOrElse(todoFound -> repository.deleteTodoById(todoFound.todoID().id()), () -> {
            throw new DbRequestException(String.format("todo entity to be deleted with id : %d " + "don't exist in Database", id));
        });
    }
}
