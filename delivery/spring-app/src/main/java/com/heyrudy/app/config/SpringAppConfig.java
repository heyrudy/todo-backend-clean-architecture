package com.heyrudy.app.config;

import com.heyrudy.config.SpringConfig;
import com.heyrudy.spring_controller.TodoController;
import com.heyrudy.core.interactors.CreateTodoUsecase;
import com.heyrudy.core.interactors.DeleteTodoByIdUsecase;
import com.heyrudy.core.interactors.GetTodoByIdUsecase;
import com.heyrudy.core.interactors.GetTodosUsecase;
import com.heyrudy.core.interactors.UpdateTodoUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringAppConfig {

    private final SpringConfig config = new SpringConfig();

    @Bean
    public CreateTodoUsecase createTodo() {
        return config.createTodo();
    }

    @Bean
    public GetTodosUsecase getTodos() {
        return config.getTodos();
    }

    @Bean
    public GetTodoByIdUsecase getTodoById() {
        return config.getTodoById();
    }

    @Bean
    public DeleteTodoByIdUsecase deleteTodoById() {
        return config.deleteTodoById();
    }

    @Bean
    public UpdateTodoUsecase updateTodo() {
        return config.updateTodo();
    }

    @Bean
    public TodoController userController() {
        return new TodoController(createTodo(),
                getTodos(),
                getTodoById(),
                updateTodo(),
                deleteTodoById());
    }
}
