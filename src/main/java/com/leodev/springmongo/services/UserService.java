package com.leodev.springmongo.services;

import com.leodev.springmongo.domain.User;
import com.leodev.springmongo.dto.UserDTO;
import com.leodev.springmongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public List<User> findAll(){
        return this.userRepository.findAll();
    }
}
