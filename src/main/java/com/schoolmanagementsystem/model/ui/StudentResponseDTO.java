package com.schoolmanagementsystem.model.ui;

import com.schoolmanagementsystem.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class StudentResponseDTO {

    private long studentId;
    private String studentFirstName;
    private String studentLastName;
    private String studentEmail;
    private String studentAddress;
    private String studentMobileNumber;
    private List<Role> studentRoles;
}
