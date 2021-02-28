package com.heyrudy.app.adapters.storage.mybatis;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.port.actions.ITodoRepository;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TodoMapper extends ITodoRepository {

    @Select("SELECT ID, TITLE, TASK, COMPLETED FROM TODOS WHERE ID = #{id}")
    @Result(column = "id", property = "id")
    Optional<Todo> getTodoById(@Param("id") final long id);

    @Select("SELECT * FROM TODOS")
    @Result(column = "id", property = "id")
    List<Todo> getTodos();

    @Insert("INSERT INTO CITY (TITLE, TASK, COMPLETED) VALUES(#{title}, #{task}, #{completed})")
    Todo saveTodo(final Todo todo);

    @Update("UPDATE TODOS SET TITLE=#{title}, TASK = #{task}, COMPLETED = #{completed} WHERE WHERE ID = #{id}")
    Todo updateTodo(final Todo todo);

    @Delete("DELETE FROM TODOS WHERE ID = #{id}")
    void deleteTodoById(@Param("id") final long id);
}
