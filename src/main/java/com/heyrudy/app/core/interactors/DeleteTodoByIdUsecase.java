package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.abilities.storage.ITodoRepository;
import com.heyrudy.app.api.exception.DbRequestException;
import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.entities.Todo.TodoID;
import org.springframework.stereotype.Component;

@Component
public record DeleteTodoByIdUsecase(ITodoRepository repository) {

    public void execute(final TodoID todoID) {
        repository.getTodoById(todoID.id()).ifPresentOrElse(todoFound -> repository.deleteTodoById(todoFound.todoID().id()), () -> {
            throw new DbRequestException(String.format("todo entity to be deleted with id : %d " + "don't exist in Database", todoID.id()));
        });
    }
}
