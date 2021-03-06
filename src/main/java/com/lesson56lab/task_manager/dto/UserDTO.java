package com.lesson56lab.task_manager.dto;

import com.lesson56lab.task_manager.model.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTO {
    private String id;
    private String name;
    private String mail;
    private String pass;

    public static UserDTO from(User user){
        return builder()
                .id(user.getId())
                .name(user.getName())
                .mail(user.getMail())
                .pass(user.getPass())
                .build();
    }
}
