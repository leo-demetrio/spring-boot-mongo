package com.leodev.springmongo.dto;

import com.leodev.springmongo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    public AuthorDTO(User user){
        id = user.getId();
        name = user.getName();
    }
}
