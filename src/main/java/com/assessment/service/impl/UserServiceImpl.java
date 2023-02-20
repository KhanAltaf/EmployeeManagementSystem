package com.assessment.service.impl;

import com.assessment.dto.request.UserForm;
import com.assessment.model.User;
import com.assessment.repository.UserRepository;
import com.assessment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<?> saveUser(UserForm userForm) {
        Map<String, Object> map = new HashMap<>();
        try {
            User user = new User(userForm);
            userRepository.save(user);
            map.put("Message: ", "User saved Successfully");
            map.put("Id:", user.getId());
            return ResponseEntity.ok(map);
        }catch (Exception e){
            log.error("Exception occur while saving User");
            return ResponseEntity.badRequest().body("Unable to save User");
        }
    }
}
