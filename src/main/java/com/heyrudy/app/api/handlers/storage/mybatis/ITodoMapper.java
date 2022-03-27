package com.heyrudy.app.api.handlers.storage.mybatis;

import java.util.List;
import java.util.Optional;

import com.heyrudy.app.core.abilities.storage.ITodoStore;
import com.heyrudy.app.core.states.Todo;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ITodoMapper extends ITodoStore {

    @Select("SELECT ID, TITLE, TASK, COMPLETED FROM TODOS WHERE ID = #{id}")
    @Result(column = "id", property = "id")
    Optional<Todo> getTodoById(@Param("id") Long id);

    @Select("SELECT * FROM TODOS")
    @Result(column = "id", property = "todoID")
    List<Todo> getTodos();

    @Insert("INSERT INTO TODOS (TITLE, TASK, COMPLETED) VALUES(#{title}, #{task}, #{completed})")
    void saveTodo(Todo todo);

    @Update("UPDATE TODOS SET TITLE=#{title}, TASK = #{task}, COMPLETED = #{completed} WHERE ID = #{id}")
    void updateTodo(Todo todo);

    @Delete("DELETE FROM TODOS WHERE ID = #{id}")
    void deleteTodoById(@Param("id") Long id);
}
