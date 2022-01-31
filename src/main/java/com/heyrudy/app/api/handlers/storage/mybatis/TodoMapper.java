package com.heyrudy.app.api.handlers.storage.mybatis;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.abilities.ITodoRepository;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TodoMapper extends ITodoRepository {

    @Select("SELECT ID, TITLE, TASK, COMPLETED FROM TODOS WHERE ID = #{id}")
    @Result(column = "id", property = "id")
    Optional<Todo> getTodoById(@Param("id") final Long id);

    @Select("SELECT * FROM TODOS")
    @Result(column = "id", property = "id")
    List<Todo> getTodos();

    @Insert("INSERT INTO TODOS (TITLE, TASK, COMPLETED) VALUES(#{title}, #{task}, #{completed})")
    void saveTodo(final Todo todo);

    @Update("UPDATE TODOS SET TITLE=#{title}, TASK = #{task}, COMPLETED = #{completed} WHERE ID = #{id}")
    void updateTodo(final Todo todo);

    @Delete("DELETE FROM TODOS WHERE ID = #{id}")
    void deleteTodoById(@Param("id") final Long id);
}
