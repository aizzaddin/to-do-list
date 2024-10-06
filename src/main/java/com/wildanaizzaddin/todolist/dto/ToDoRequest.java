package com.wildanaizzaddin.todolist.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToDoRequest {
    private String title;
    private String description;
}
