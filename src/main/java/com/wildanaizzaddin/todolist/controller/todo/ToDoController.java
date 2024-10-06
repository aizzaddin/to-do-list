package com.wildanaizzaddin.todolist.controller.todo;

import com.wildanaizzaddin.todolist.dto.ToDoRequest;
import com.wildanaizzaddin.todolist.dto.ToDoResponse;
import com.wildanaizzaddin.todolist.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("api/v1/todo")
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @PostMapping("/")
    public ResponseEntity<ToDoResponse> addNewToDo(@RequestBody ToDoRequest toDoRequest,
                                                   Authentication auth) {
        ToDoResponse response = toDoService.addToDo(toDoRequest, auth);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoResponse> getToDoById(@PathVariable("id") String id, Authentication auth)
            throws AuthenticationException {
        ToDoResponse response = toDoService.getToDo(id, auth);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
