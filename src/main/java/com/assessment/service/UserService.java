package com.assessment.service;

import com.assessment.dto.request.UserForm;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> saveUser(UserForm userForm);
}
