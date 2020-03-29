package com.lesson56lab.task_manager.dto;

import com.lesson56lab.task_manager.model.Task;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class GetTaskDTO {
    private String id;
    private String title;
    private String status;
    private LocalDateTime date;
    private String userId;

    public static GetTaskDTO getTaskDTO(Task task){
        return builder()
                .id(task.getId())
                .title(task.getTitle())
                .status(task.getStatus().getName())
                .date(task.getEndDate())
                .userId(task.getUser().getId())
                .build();
    }

}
