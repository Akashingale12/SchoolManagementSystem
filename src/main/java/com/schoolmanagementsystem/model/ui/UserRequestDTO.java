package com.schoolmanagementsystem.model.ui;

import com.schoolmanagementsystem.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDTO {
    private String firstName;
    private String lastName;
    private List<Role> userRoles;
    private String email;
    private String mobileNumber;
    private String address;
}
