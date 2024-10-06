package com.wildanaizzaddin.todolist.service;

import com.wildanaizzaddin.todolist.dto.ToDoRequest;
import com.wildanaizzaddin.todolist.dto.ToDoResponse;
import org.springframework.security.core.Authentication;

import javax.naming.AuthenticationException;

public interface ToDoService {
    ToDoResponse addToDo(ToDoRequest toDoRequest, Authentication auth);
    ToDoResponse getToDo(String id, Authentication auth) throws AuthenticationException;
}
