package com.schoolmanagementsystem.controller;

import com.schoolmanagementsystem.model.ui.ListUserResponseDTO;
import com.schoolmanagementsystem.model.ui.UserRequestDTO;
import com.schoolmanagementsystem.model.ui.UserResponseDTO;
import com.schoolmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "adduser")
    private UserResponseDTO addNewUser(@RequestBody UserRequestDTO userRequestDTO){
        return userService.addUser(userRequestDTO);
    }

    @RequestMapping(method = RequestMethod.POST, path = "updateuser/{userId}")
    private UserResponseDTO updateUser(@RequestParam long userId, @RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO = userService.updateUser(userId,userRequestDTO);
        return userResponseDTO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "getuser/{userId}")
    private UserResponseDTO getUserById(@RequestParam long userId){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO = userService.getUserById(userId);
        return userResponseDTO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "getalluser")
    private List<UserResponseDTO> getAllUserList(){
        List<UserResponseDTO> userResponseDTOS = userService.getAllUsersList();
        return userResponseDTOS;
    }
}
