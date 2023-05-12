package com.schoolmanagementsystem.model.ui;

import com.schoolmanagementsystem.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class TeacherDTOResponse {
    private long teacherId;
    private String teacherFirstName;
    private String teacherLastName;
    private String teacherMobileNumber;
    private List<Role> teacherRoles;
    private String teacherAddress;

    private String teacherEmail;
}
