package com.assessment.security.service;

import com.assessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailServiceImpl implements CustomUserDetailService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.assessment.model.User user = userRepository.findByUserName(username);
        if(user != null){
            return new User(user.getUserName(),user.getPassword(),new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User Not Found");
        }

    }
}
