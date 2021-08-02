package com.heyrudy.app.aggregates;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.interactors.CreateTodoUsecase;
import com.heyrudy.app.core.interactors.DeleteTodoByIdUsecase;
import com.heyrudy.app.core.interactors.UpdateTodoUsecase;
import org.springframework.stereotype.Component;

@Component
public final class TodoCommand {

    private final CreateTodoUsecase createTodo;
    private final UpdateTodoUsecase updateTodo;
    private final DeleteTodoByIdUsecase deleteTodoById;

    public TodoCommand(CreateTodoUsecase createTodo, UpdateTodoUsecase updateTodo,
                       DeleteTodoByIdUsecase deleteTodoById) {
        this.createTodo = createTodo;
        this.updateTodo = updateTodo;
        this.deleteTodoById = deleteTodoById;
    }

    public void createTodo(final Todo todo) {
        createTodo.execute(todo);
    }

    public void updateTodo(final Long id, final Todo todo) {
        updateTodo.execute(id, todo);
    }

    public void deleteTodoById(final Long id) {
        deleteTodoById.execute(id);
    }
}
