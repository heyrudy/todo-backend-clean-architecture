package com.heyrudy.config;

import com.heyrudy.aggregates.TodoCommand;
import com.heyrudy.aggregates.TodoQuery;
import com.heyrudy.core.interactors.CreateTodoUsecase;
import com.heyrudy.core.interactors.DeleteTodoByIdUsecase;
import com.heyrudy.core.interactors.GetTodoByIdUsecase;
import com.heyrudy.core.interactors.GetTodosUsecase;
import com.heyrudy.core.interactors.UpdateTodoUsecase;
import com.heyrudy.core.abilities.storage.ITodoRepository;
import com.heyrudy.storage.mocks.TodoStorageMocksImpl;

public class SpringConfig {

    private final ITodoRepository todoRepository = new TodoStorageMocksImpl();

    public CreateTodoUsecase createTodo() {
        return new CreateTodoUsecase(todoRepository);
    }

    public UpdateTodoUsecase updateTodo() {
        return new UpdateTodoUsecase(todoRepository);
    }

    public DeleteTodoByIdUsecase deleteTodoById() {
        return new DeleteTodoByIdUsecase(todoRepository);
    }

    public GetTodosUsecase getTodos() {
        return new GetTodosUsecase(todoRepository);
    }

    public GetTodoByIdUsecase getTodoById() {
        return new GetTodoByIdUsecase(todoRepository);
    }

    public TodoQuery todoQuery() {
        return new TodoQuery(getTodos(), getTodoById());
    }

    public TodoCommand todoCommand() {
        return new TodoCommand(createTodo(), updateTodo(), deleteTodoById());
    }
}
