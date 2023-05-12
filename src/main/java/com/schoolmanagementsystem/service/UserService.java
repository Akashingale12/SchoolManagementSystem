package com.schoolmanagementsystem.service;

import com.schoolmanagementsystem.model.Role;
import com.schoolmanagementsystem.model.User;
import com.schoolmanagementsystem.model.ui.*;
import com.schoolmanagementsystem.repository.RoleRepository;
import com.schoolmanagementsystem.repository.UserRepository;
import com.schoolmanagementsystem.utils.RoleConstant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO;
        List<Role> roleList = new ArrayList<>();
        User user = modelMapper.map(userRequestDTO, User.class);

        for(Role role : userRequestDTO.getUserRoles()){
            Role Roles = roleRepository.findById(role.getId());
            Role role1 = new Role();
            role1.setId(Roles.getId());
            role1.setRoleName(Roles.getRoleName());
            roleList.add(role1);
        }
        user.setUserRoles(roleList);
        User savedUser = userRepository.save(user);
        return userResponseDTO = modelMapper.map(savedUser,UserResponseDTO.class);
    }

    public UserResponseDTO updateUser(long userId,UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            user.get().setFirstName(userRequestDTO.getFirstName());
            user.get().setLastName(userRequestDTO.getLastName());
            user.get().setEmail(userRequestDTO.getEmail());
            user.get().setAddress(userRequestDTO.getAddress());
            user.get().getUserRoles().clear();
            user.get().setUserRoles(userRequestDTO.getUserRoles());
            user.get().setMobileNumber(userRequestDTO.getMobileNumber());
             userResponseDTO = modelMapper.map(user.get(),UserResponseDTO.class);
        }else {

        }
        return userResponseDTO;
    }


    public UserResponseDTO getUserById(long userId){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            userResponseDTO = modelMapper.map(user.get(),UserResponseDTO.class);
        }else {

        }
        return userResponseDTO;
    }

    public List<UserResponseDTO> getAllUsersList(){
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for(User user : userList){
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.setId(user.getId());
            userResponseDTO.setFirstName(user.getFirstName());
            userResponseDTO.setLastName(user.getLastName());
            userResponseDTO.setAddress(user.getAddress());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setMobileNumber(user.getMobileNumber());
            userResponseDTO.setUserRoles(user.getUserRoles());
            userResponseDTOS.add(userResponseDTO);
        }
        return userResponseDTOS;
    }

    public UserResponseDTO addTeacher(TeacherDTOReqeust teacherDTOReqeust){
        UserResponseDTO userResponseDTO;
        User user = modelMapper.map(teacherDTOReqeust, User.class);
        List<Role> role = roleRepository.findRoleByName(RoleConstant.TEACHER.value);
        user.setUserRoles(role);
        User savedUser = userRepository.save(user);
        return userResponseDTO = modelMapper.map(savedUser,UserResponseDTO.class);
    }

    public UserResponseDTO addStudent(StudentRequestDTO studentRequestDTO){
        UserResponseDTO userResponseDTO;
        User user = modelMapper.map(studentRequestDTO, User.class);
        List<Role> role = roleRepository.findRoleByName(RoleConstant.STUDENT.value);
        user.setUserRoles(role);
        User savedUser = userRepository.save(user);
        return userResponseDTO = modelMapper.map(savedUser,UserResponseDTO.class);
    }

    public UserResponseDTO updateStudent(long studentId,StudentRequestDTO studentRequestDTO){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        Optional<User> user = userRepository.findById(studentId);
        if (user.isPresent() && user.get().getUserRoles().stream().anyMatch(a->a.getRoleName().equalsIgnoreCase(RoleConstant.STUDENT.value))){
            User user1 = modelMapper.map(studentRequestDTO, User.class);
            user1.setId(studentId);
            List<Role> role = roleRepository.findRoleByName(RoleConstant.STUDENT.value);
            user1.setUserRoles(role);
            User savedUser = userRepository.save(user1);
            userResponseDTO = modelMapper.map(savedUser,UserResponseDTO.class);
        }else {

        }
        return userResponseDTO;
    }

    public UserResponseDTO updateTeacher(long teacherId,TeacherDTOReqeust teacherDTOReqeust){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        Optional<User> user = userRepository.findById(teacherId);
        if (user.isPresent() && user.get().getUserRoles().stream().anyMatch(a->a.getRoleName().equalsIgnoreCase(RoleConstant.TEACHER.value))){
            User user1 = modelMapper.map(teacherDTOReqeust, User.class);
            user1.setId(teacherId);
            List<Role> role = roleRepository.findRoleByName(RoleConstant.TEACHER.value);
            user1.setUserRoles(role);
            User savedUser = userRepository.save(user1);
            userResponseDTO = modelMapper.map(savedUser,UserResponseDTO.class);
        }else {

        }
        return userResponseDTO;
    }
}
