package com.lesson56lab.task_manager.repository;

import com.lesson56lab.task_manager.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
    User findUserByName(String name);
    User findUserByMail(String mail);
}
