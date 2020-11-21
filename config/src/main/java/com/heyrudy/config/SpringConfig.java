package com.heyrudy.config;

import com.heyrudy.core.interactors.CreateTodoUsecase;
import com.heyrudy.core.interactors.DeleteTodoByIdUsecase;
import com.heyrudy.core.interactors.GetTodoByIdUsecase;
import com.heyrudy.core.interactors.GetTodosUsecase;
import com.heyrudy.core.interactors.UpdateTodoUsecase;
import com.heyrudy.core.port.actions.ITodoRepository;
import com.heyrudy.storage.in_memory.InMemoryTodoRepositoryImpl;

public class SpringConfig {

    private final ITodoRepository todoRepository = new InMemoryTodoRepositoryImpl();

    public CreateTodoUsecase createTodo() {
        return new CreateTodoUsecase(todoRepository);
    }

    public GetTodosUsecase getTodos() {
        return new GetTodosUsecase(todoRepository);
    }

    public GetTodoByIdUsecase getTodoById() {
        return new GetTodoByIdUsecase(todoRepository);
    }

    public UpdateTodoUsecase updateTodo() {
        return new UpdateTodoUsecase(todoRepository);
    }

    public DeleteTodoByIdUsecase deleteTodoById() {
        return new DeleteTodoByIdUsecase(todoRepository);
    }
}
