package com.gsoftcode.cescortback.entity;

import com.gsoftcode.cescortback.dto.UserDto;
import com.gsoftcode.cescortback.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String email;

    private String password;

    private String lastname;

    private String phone;

    private UserRole role;



    public UserDto getDto(){
        UserDto userDto = new UserDto();

        userDto.setId(id);
        userDto.setLastname(lastname);
        userDto.setEmail(email);
        userDto.setRole(role);

        return userDto;
    }
}
