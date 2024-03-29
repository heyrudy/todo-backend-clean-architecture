package com.heyrudy.core.interactors;

import com.heyrudy.core.abilities.storage.ITodoRepository;

public final class DeleteTodoByIdUsecase {

    private final ITodoRepository repository;

    public DeleteTodoByIdUsecase(ITodoRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteTodo(id);
    }
}
