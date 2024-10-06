package com.wildanaizzaddin.todolist.service.impl;

import com.wildanaizzaddin.todolist.dto.ToDoRequest;
import com.wildanaizzaddin.todolist.dto.ToDoResponse;
import com.wildanaizzaddin.todolist.model.TodoEntity;
import com.wildanaizzaddin.todolist.model.UserEntity;
import com.wildanaizzaddin.todolist.repository.TodoRepository;
import com.wildanaizzaddin.todolist.service.AuthenticationService;
import com.wildanaizzaddin.todolist.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
    private final TodoRepository todoRepository;
    private final AuthenticationService authenticationService;

    @Override
    public ToDoResponse addToDo(ToDoRequest request, Authentication auth) {
        UserEntity user = authenticationService
                .getUserByEmail(auth.getName());
        try {
            TodoEntity todo = TodoEntity
                    .builder()
                    .title(request.getTitle())
                    .description(request.getDescription())
                    .user(user)
                    .build();

            todoRepository.save(todo);
            return ToDoResponse.of(todo);
        } catch (Exception e) {
            throw new RuntimeException("Error while adding new todo", e);
        }
    }

    @Override
    public ToDoResponse getToDo(String id, Authentication auth) throws AuthenticationException {
        TodoEntity todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));

        if (!auth.getName().equals(todo.getUser().getEmail())) {
            throw new AuthenticationException("Access Denied");
        }

        return ToDoResponse.of(todo);
    }
}
