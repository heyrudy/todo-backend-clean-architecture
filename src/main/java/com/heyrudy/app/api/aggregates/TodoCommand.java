package com.heyrudy.app.api.aggregates;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.interactors.CreateTodoUsecase;
import com.heyrudy.app.core.interactors.DeleteTodoByIdUsecase;
import com.heyrudy.app.core.interactors.UpdateTodoUsecase;
import org.springframework.stereotype.Component;

@Component
public record TodoCommand(CreateTodoUsecase createTodoUsecase, UpdateTodoUsecase updateTodoUsecase, DeleteTodoByIdUsecase deleteTodoByIdUsecase) {


    public void createTodo(final Todo todo) {
        createTodoUsecase.execute(todo);
    }

    public void updateTodo(final Long id, final Todo todo) {
        updateTodoUsecase.execute(id, todo);
    }

    public void deleteTodoById(final Long id) {
        deleteTodoByIdUsecase.execute(id);
    }
}
