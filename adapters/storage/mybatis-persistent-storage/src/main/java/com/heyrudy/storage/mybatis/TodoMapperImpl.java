package com.heyrudy.storage.mybatis;

import com.heyrudy.core.entities.Todo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Optional;

public final class TodoMapperImpl implements TodoMapper {

    private final SqlSessionFactory sqlSessionFactory;

    public TodoMapperImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private TodoMapper getTodoMapper(final SqlSession sqlSession) {
        return sqlSession.getMapper(TodoMapper.class);
    }

    @Override
    public Optional<Todo> getTodoById(final long id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return getTodoMapper(sqlSession).getTodoById(id);
        }
    }

    @Override
    public List<Todo> getTodos() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return getTodoMapper(sqlSession).getTodos();
        }
    }

    @Override
    public Todo saveTodo(final Todo todo) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            final Todo savedTodo = getTodoMapper(sqlSession).saveTodo(todo);
            sqlSession.commit();
            return savedTodo;
        }
    }

    @Override
    public Todo updateTodo(final Todo todo) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            final Todo updatedTodo = getTodoMapper(sqlSession).updateTodo(todo);
            sqlSession.commit();
            return updatedTodo;
        }
    }

    @Override
    public void deleteTodoById(final long id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            getTodoMapper(sqlSession).deleteTodoById(id);
            sqlSession.commit();
        }
    }
}
