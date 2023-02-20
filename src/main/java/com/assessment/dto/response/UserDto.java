package com.assessment.dto.response;

import com.assessment.model.User;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String userName;
    private String password;

    public UserDto(User user){
        this.id = user.getId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
    }
}
