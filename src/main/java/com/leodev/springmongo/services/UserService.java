package com.leodev.springmongo.services;

import com.leodev.springmongo.domain.User;
import com.leodev.springmongo.dto.UserDTO;
import com.leodev.springmongo.exception.ObjectNotFoundException;
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
    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
    public User insert(User user){
        return userRepository.insert(user);
    }
    public User update(User obj){
        User user = findById(obj.getId());
        User userUpdate = updateData(user,obj);
        return userRepository.save(userUpdate);
    }
    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }
    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
    }
    private User updateData(User user, User obj){
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        return user;
    }
}
