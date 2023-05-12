package com.schoolmanagementsystem.controller;

import com.schoolmanagementsystem.model.ui.StudentRequestDTO;
import com.schoolmanagementsystem.model.ui.UserResponseDTO;
import com.schoolmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/addstudent")
    public UserResponseDTO addStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        UserResponseDTO userResponseDTO = userService.addStudent(studentRequestDTO);
        return userResponseDTO;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/updatestudent/{studentId}")
    public UserResponseDTO updateStudent(@RequestParam(value = "studentId") long studentId, @RequestBody StudentRequestDTO studentRequestDTO){
        UserResponseDTO userResponseDTO = userService.updateStudent(studentId,studentRequestDTO);
        return userResponseDTO;
    }
}
