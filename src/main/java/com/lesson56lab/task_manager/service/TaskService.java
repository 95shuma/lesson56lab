package com.lesson56lab.task_manager.service;

import com.lesson56lab.task_manager.dto.CreateTaskDTO;
import com.lesson56lab.task_manager.dto.DetailTaskDTO;
import com.lesson56lab.task_manager.dto.GetTaskDTO;
import com.lesson56lab.task_manager.model.Task;
import com.lesson56lab.task_manager.model.User;
import com.lesson56lab.task_manager.repository.TaskRepository;
import com.lesson56lab.task_manager.repository.UserRepository;
import com.lesson56lab.task_manager.state.StateContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.ApiIgnore;


@Service
public class TaskService {
    @Autowired
    UserRepository ur;

    @Autowired
    TaskRepository tr;

    public Iterable<GetTaskDTO> getAllTask(@ApiIgnore Pageable pageable, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        String id = user.getId();
        return tr.findAllByUserId(pageable,id)
                .map(GetTaskDTO::getTaskDTO);
    }

    public DetailTaskDTO createTask(CreateTaskDTO createTaskDTO, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        Task task = Task.builder()
                .title(createTaskDTO.getTitle())
                .description(createTaskDTO.getDescription())
                .endDate(createTaskDTO.getEndDate())
                .user(user)
                .status(new StateContext())
                .build();
        tr.save(task);
        return DetailTaskDTO.from(task);
    }

    public DetailTaskDTO changeStatus(String id){
        Task task = tr.findTaskById(id);
        tr.delete(task);
        task.getStatus().heat();
        tr.save(task);
        return DetailTaskDTO.from(task);
    }

    public DetailTaskDTO getTask(String id){
        Task task = tr.findTaskById(id);
        return DetailTaskDTO.from(task);
    }

}
