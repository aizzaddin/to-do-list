package com.wildanaizzaddin.todolist.dto;

import com.wildanaizzaddin.todolist.model.TodoEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToDoResponse {
    private String id;
    private String title;
    private String description;

    public static ToDoResponse of(TodoEntity entity) {
        return ToDoResponse
                .builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .build();
    }
}
