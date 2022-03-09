package com.heyrudy.storage.mybatis;

import com.heyrudy.core.entities.Todo;
import com.heyrudy.core.abilities.storage.ITodoRepository;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface IMybatisPersistentTodoRepository extends ITodoRepository {

    @Select("SELECT ID, NAME, STATE, COUNTRY FROM TODOS WHERE ID = #{id}")
    @Result(column = "id", property = "todoId")
    Optional<Todo> getTodoById(@Param("id") final long id);

    @Select("SELECT * FROM TODOS")
    @Result(column = "id", property = "todoId")
    List<Todo> getTodos();

    @Insert("INSERT INTO CITY (NAME, STATE, COUNTRY) VALUES(#{name}, #{state}, #{country})")
    Todo saveTodo(final Todo todo);

    @Update("UPDATE TODOS SET NAME=#{name}, STATE = #{state}, COUNTRY = #{country} WHERE WHERE ID = #{id}")
    Todo updateTodo(final Todo todo);

    @Delete("DELETE FROM TODOS WHERE ID = #{id}")
    void deleteTodo(@Param("id") final long id);
}
