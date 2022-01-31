package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.abilities.ITodoRepository;
import org.springframework.stereotype.Component;

@Component
public record CreateTodoUsecase(ITodoRepository repository) {

    public void execute(final Todo todo) {
        repository.saveTodo(todo);
    }
}
