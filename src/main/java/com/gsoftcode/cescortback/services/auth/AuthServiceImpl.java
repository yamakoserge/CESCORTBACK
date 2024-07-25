package com.gsoftcode.cescortback.services.auth;

import com.gsoftcode.cescortback.dto.SignupRequestDTO;
import com.gsoftcode.cescortback.dto.UserDto;
import com.gsoftcode.cescortback.entity.User;
import com.gsoftcode.cescortback.enums.UserRole;
import com.gsoftcode.cescortback.repository.CescortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private CescortRepository cescortRepository;

    public UserDto signupClient(SignupRequestDTO signupRequestDTO){
        User user = new User();

        user.setLastname(signupRequestDTO.getLastname());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));

        user.setRole(UserRole.CLIENT);

        return cescortRepository.save(user).getDto();


    }

    @Override
    public boolean presentByEmail(String email) {
        return cescortRepository.findFirstByEmail(email) !=null;
    }
}
