package com.heyrudy.app.api.aggregates;

import com.heyrudy.app.core.states.Todo;
import com.heyrudy.app.core.usecases.CreateTodoUsecase;
import com.heyrudy.app.core.usecases.DeleteTodoByIdUsecase;
import com.heyrudy.app.core.usecases.UpdateTodoUsecase;

import org.springframework.stereotype.Component;

@Component
public record TodoCommand(CreateTodoUsecase createTodoUsecase, UpdateTodoUsecase updateTodoUsecase, DeleteTodoByIdUsecase deleteTodoByIdUsecase) {

    public void createTodo(final Todo todo) {
        createTodoUsecase.execute(todo);
    }

    public void updateTodo(final Long todoID, final Todo todo) {
        updateTodoUsecase.execute(todoID, todo);
    }

    public void deleteTodoById(final Long todoID) {
        deleteTodoByIdUsecase.execute(todoID);
    }
}
