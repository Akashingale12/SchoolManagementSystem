package com.schoolmanagementsystem.model.ui;

import com.schoolmanagementsystem.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {
    private long id;
    private String firstName;
    private String lastName;
    private List<Role> userRoles;
    private String email;
    private String mobileNumber;
    private String address;
}
