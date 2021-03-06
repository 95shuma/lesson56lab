package com.lesson56lab.task_manager.controller;

import com.lesson56lab.task_manager.dto.CreateTaskDTO;
import com.lesson56lab.task_manager.dto.DetailTaskDTO;
import com.lesson56lab.task_manager.dto.GetTaskDTO;
import com.lesson56lab.task_manager.service.TaskService;
import org.springframework.security.core.Authentication;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/task")
public class TaskController {
    TaskService ts;

    public TaskController(TaskService ts) {
        this.ts = ts;
    }

    @PostMapping()
    public DetailTaskDTO createTask(@RequestBody CreateTaskDTO createTaskDTO,Authentication authentication){
        return ts.createTask(createTaskDTO,authentication);
    }

    @GetMapping("/all")
    public Iterable<GetTaskDTO> findAll(@ApiIgnore Pageable pageable, Authentication authentication){
        return ts.getAllTask(pageable,authentication);
    }

    @GetMapping("/change/id/{id}")
    public DetailTaskDTO changeStatus(@PathVariable("id")String id){
        return ts.changeStatus(id);
    }

    @GetMapping("/id/{id}")
    public DetailTaskDTO getTask(@PathVariable("id")String id){
        return ts.getTask(id);
    }
}
