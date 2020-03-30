package com.lesson56lab.task_manager.repository;

import com.lesson56lab.task_manager.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TaskRepository extends PagingAndSortingRepository<Task,String> {
    Task findTaskById(String id);
    Page<Task> findAllByUserId(Pageable pageable,String id);
}
