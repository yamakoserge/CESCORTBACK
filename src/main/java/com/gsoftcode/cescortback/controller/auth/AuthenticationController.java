package com.gsoftcode.cescortback.controller.auth;

import com.gsoftcode.cescortback.dto.SignupRequestDTO;
import com.gsoftcode.cescortback.dto.UserDto;
import com.gsoftcode.cescortback.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthService authService;

    @PostMapping("/cescort/signup")
    public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTO  signupRequestDTO){
        if (authService.presentByEmail(signupRequestDTO.getEmail())){
            return new ResponseEntity<>("Ce Utilisateur existe déjà !", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createUser = authService.signupClient(signupRequestDTO);

        return new ResponseEntity<>(createUser,HttpStatus.OK);
    }

}
