package com.heyrudy.app.aggregates;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.interactors.CreateTodoUsecase;
import com.heyrudy.app.core.interactors.DeleteTodoByIdUsecase;
import com.heyrudy.app.core.interactors.UpdateTodoUsecase;
import com.heyrudy.app.aggregates.dto.TodoDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.heyrudy.app.aggregates.dto.TodoDto.toTodoDto;

@Component
public final class TodoCommand {

    private final CreateTodoUsecase createTodo;
    private final UpdateTodoUsecase updateTodo;
    private final DeleteTodoByIdUsecase deleteTodoById;

    public TodoCommand(CreateTodoUsecase createTodo,
                       UpdateTodoUsecase updateTodo,
                       DeleteTodoByIdUsecase deleteTodoById) {
        this.createTodo = createTodo;
        this.updateTodo = updateTodo;
        this.deleteTodoById = deleteTodoById;
    }

    public TodoDto createTodo(final Todo todo) {
        return toTodoDto(createTodo.execute(todo));
    }


    public Optional<TodoDto> updateTodo(final Long id, final Todo todo) {
        return updateTodo.execute(id, todo)
                .map(TodoDto::toTodoDto);
    }

    public void deleteTodoById(final Long id) {
        deleteTodoById.execute(id);
    }
}
