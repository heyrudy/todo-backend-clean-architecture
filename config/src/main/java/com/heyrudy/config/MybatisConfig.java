package com.heyrudy.config;

import com.heyrudy.core.interactors.CreateTodoUsecase;
import com.heyrudy.core.interactors.DeleteTodoByIdUsecase;
import com.heyrudy.core.interactors.GetTodoByIdUsecase;
import com.heyrudy.core.interactors.GetTodosUsecase;
import com.heyrudy.core.interactors.UpdateTodoUsecase;
import com.heyrudy.core.port.actions.ITodoRepository;
import com.heyrudy.storage.mybatis.TodoMapperImpl;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {

    private final Configuration configuration = new Configuration();
    private final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    private final ITodoRepository todoRepository = new TodoMapperImpl(sqlSessionFactory);

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
