package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.abilities.ITodoRepository;
import com.heyrudy.app.api.exception.DbRequestException;
import org.springframework.stereotype.Component;

@Component
public record UpdateTodoUsecase(ITodoRepository repository) {

    public void execute(final Long id, final Todo todo) {
        repository.getTodoById(id).ifPresentOrElse(todoFound -> repository.updateTodo(todo.withId(todoFound.todoID())), () -> {
            throw new DbRequestException(String.format("todo entity to be updated with id : %d " + "don't exist in Database", id));
        });
    }
}
