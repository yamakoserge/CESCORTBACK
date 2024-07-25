package com.gsoftcode.cescortback.services.auth;

import com.gsoftcode.cescortback.dto.SignupRequestDTO;
import com.gsoftcode.cescortback.dto.UserDto;

public interface AuthService {

    UserDto signupClient(SignupRequestDTO signupRequestDTO);

    boolean presentByEmail(String email);
}
