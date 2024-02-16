package com.example.demo.service;

import com.example.demo.aspects.TrackUserAction;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }
    @TrackUserAction
    public User saveUser(User user){
        return userRepository.save(user);
    }
    @TrackUserAction
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    @TrackUserAction
    public void update(User user) {
        userRepository.update(user);
    }

    public User getUser(int id) {
        return userRepository.getUser(id);
    }
}
