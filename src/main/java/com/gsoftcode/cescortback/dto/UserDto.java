package com.gsoftcode.cescortback.dto;

import com.gsoftcode.cescortback.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String email;

    private String password;

    private String lastname;

    private String phone;

    private UserRole role;
}
