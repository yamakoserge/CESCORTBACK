package com.gsoftcode.cescortback.services.auth;

import com.gsoftcode.cescortback.dto.SignupRequestDTO;
import com.gsoftcode.cescortback.dto.UserDto;
import com.gsoftcode.cescortback.entity.User;
import com.gsoftcode.cescortback.enums.UserRole;
import com.gsoftcode.cescortback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    public UserDto signupClient(SignupRequestDTO signupRequestDTO){
        User user = new User();

        user.setLastname(signupRequestDTO.getLastname());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));

        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();


    }
    @Override
    public boolean presentByEmail(String email) {
        return userRepository.findFirstByEmail(email) !=null;
    }
}
