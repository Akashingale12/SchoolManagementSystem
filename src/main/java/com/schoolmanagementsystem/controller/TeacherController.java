package com.schoolmanagementsystem.controller;

import com.schoolmanagementsystem.model.ui.TeacherDTOReqeust;
import com.schoolmanagementsystem.model.ui.UserResponseDTO;
import com.schoolmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/addteacher/")
    public UserResponseDTO addTeacher(@RequestBody TeacherDTOReqeust teacherDTOReqeust){
        UserResponseDTO userResponseDTO;
        userResponseDTO = userService.addTeacher(teacherDTOReqeust);
        return userResponseDTO;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/updateteacher/{teacherId}")
    public UserResponseDTO updateTeacher(@RequestParam(value = "teacherId") long teacherId, @RequestBody TeacherDTOReqeust teacherDTOReqeust){
        UserResponseDTO userResponseDTO;
        userResponseDTO = userService.updateTeacher(teacherId,teacherDTOReqeust);
        return userResponseDTO;
    }
}
