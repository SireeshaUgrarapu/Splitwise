package dev.siri.Splitwise.controller;

import dev.siri.Splitwise.dto.UserLoginRequestDTO;
import dev.siri.Splitwise.dto.UserRegistrationRequestDTO;
import dev.siri.Splitwise.entity.User;
import dev.siri.Splitwise.exception.UserRegistrationInvalidDataException;
import dev.siri.Splitwise.mapper.EntityDTOMapper;
import dev.siri.Splitwise.service.strategy.settleUpStrategy.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO){
        validateUserRegistrationRequestDTO(userRegistrationRequestDTO);
        User savedUser =userService.signup(userRegistrationRequestDTO.getName(), userRegistrationRequestDTO.getEmail(), userRegistrationRequestDTO.getPassword());
        return ResponseEntity.ok(
                EntityDTOMapper.toDTO(savedUser)
        );
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDTO userLoginRequestDTO){
        validateUserLoginRequestDTO(userLoginRequestDTO);
        User savedUser = userService.login(userLoginRequestDTO.getEmail(), userLoginRequestDTO.getPassword());
        return ResponseEntity.ok(EntityDTOMapper.toDTO(savedUser));
    }


    private void validateUserRegistrationRequestDTO(UserRegistrationRequestDTO requestDTO){
        // do both using regex
       //TODO : validate if the email is proper
       //TODO : validate if password has atleast 8 characters including a small, capital, numeric and special character
        if(requestDTO.getEmail() == null || requestDTO.getName() == null ||requestDTO.getPassword() == null){
            throw new UserRegistrationInvalidDataException("Invalid sign up data");
        }
    }


    private void validateUserLoginRequestDTO(UserLoginRequestDTO userLoginRequestDTO){

    }

}
