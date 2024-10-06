package com.wildanaizzaddin.todolist.repository;

import com.wildanaizzaddin.todolist.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, String> {
}
