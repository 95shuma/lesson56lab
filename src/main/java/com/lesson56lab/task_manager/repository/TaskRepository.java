package com.lesson56lab.task_manager.repository;

import com.lesson56lab.task_manager.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

public interface TaskRepository extends PagingAndSortingRepository<Task,String> {
    Task findTaskById(String id);
}
