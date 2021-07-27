package com.heyrudy.app.router;

import com.heyrudy.app.router.dto.TodoDto;
import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.interactors.CreateTodoUsecase;
import com.heyrudy.app.core.interactors.DeleteTodoByIdUsecase;
import com.heyrudy.app.core.interactors.GetTodoByIdUsecase;
import com.heyrudy.app.core.interactors.GetTodosUsecase;
import com.heyrudy.app.core.interactors.UpdateTodoUsecase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.heyrudy.app.router.dto.TodoDto.toTodoDto;

@Component
public final class TodoRouter {

    private final CreateTodoUsecase createTodo;
    private final GetTodosUsecase getTodos;
    private final GetTodoByIdUsecase getTodoById;
    private final UpdateTodoUsecase updateTodo;
    private final DeleteTodoByIdUsecase deleteTodoById;

    public TodoRouter(CreateTodoUsecase createTodo,
                      GetTodosUsecase getTodos,
                      GetTodoByIdUsecase getTodoById,
                      UpdateTodoUsecase updateTodo,
                      DeleteTodoByIdUsecase deleteTodoById) {
        this.createTodo = createTodo;
        this.getTodos = getTodos;
        this.getTodoById = getTodoById;
        this.updateTodo = updateTodo;
        this.deleteTodoById = deleteTodoById;
    }

    public TodoDto createTodo(final Todo todo) {
        return toTodoDto(createTodo.execute(todo));
    }

    public List<TodoDto> getTodos() {
        return getTodos.execute()
                .stream()
                .map(TodoDto::toTodoDto)
                .collect(Collectors.toList());
    }

    public Optional<TodoDto> getTodoById(final long id) {
        return getTodoById.execute(id)
                .map(TodoDto::toTodoDto);
    }

    public Optional<TodoDto> updateTodo(final long id, final Todo todo) {
        return updateTodo.execute(id, todo)
                .map(TodoDto::toTodoDto);
    }

    public void deleteTodoById(final long id) {
        deleteTodoById.execute(id);
    }
}
