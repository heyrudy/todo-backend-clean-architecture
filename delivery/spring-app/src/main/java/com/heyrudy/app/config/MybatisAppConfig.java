//package com.heyrudy.app.config;
//
//
//import com.heyrudy.config.MybatisConfig;
//import com.heyrudy.core.interactors.*;
//import com.heyrudy.router.spring_router.TodoRouter;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MybatisAppConfig {
//
//    private final MybatisConfig config = new MybatisConfig();
//
//    @Bean
//    public org.apache.ibatis.session.Configuration getConfiguration() {
//        return new org.apache.ibatis.session.Configuration();
//    }
//
//    @Bean
//    public SqlSessionFactory getSqlSessionFactory(org.apache.ibatis.session.Configuration configuration) {
//        return new SqlSessionFactoryBuilder().build(configuration);
//    }
//
//    @Bean
//    public CreateTodoUsecase createTodo() {
//        return config.createTodo();
//    }
//
//    @Bean
//    public GetTodosUsecase getTodos() {
//        return config.getTodos();
//    }
//
//    @Bean
//    public GetTodoByIdUsecase getTodoById() {
//        return config.getTodoById();
//    }
//
//    @Bean
//    public DeleteTodoByIdUsecase deleteTodoById() {
//        return config.deleteTodoById();
//    }
//
//    @Bean
//    public UpdateTodoUsecase updateTodo() {
//        return config.updateTodo();
//    }
//
//    @Bean(name = "mybatisServiceRouter")
//    public TodoRouter userRouter() {
//        return new TodoRouter(createTodo(),
//                getTodos(),
//                getTodoById(),
//                updateTodo(),
//                deleteTodoById());
//    }
//}
