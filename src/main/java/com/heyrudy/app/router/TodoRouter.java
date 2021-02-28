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

    public TodoDto createTodo(final TodoDto todoDto) {
        Todo todo = todoDto.toTodo();
        return toTodoDto(createTodo.execute(todo));
    }

    public List<TodoDto> getTodos() {
        return getTodos.execute()
                .stream()
                .map(TodoDto::toTodoDto)
                .collect(Collectors.toList());
    }

    public Optional<TodoDto> getTodoById(final long id) {
        final Optional<Todo> todoOptional = getTodoById.execute(id);
        if (todoOptional.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(toTodoDto(todoOptional.get()));
    }

    public Optional<TodoDto> updateTodo(final long id, final TodoDto todoDto) {
        Todo todo = todoDto.toTodo();
        final Optional<Todo> todoOptional = updateTodo.execute(id, todo);
        if (todoOptional.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(toTodoDto(todoOptional.get()));
    }

    public void deleteTodoById(final long id) {
        deleteTodoById.execute(id);
    }
}
