package com.schoolmanagementsystem.model.ui;

import lombok.Data;

@Data
public class TeacherDTOReqeust {
    private String teacherFirstName;
    private String teacherLastName;
    private String teacherMobileNumber;
    private String teacherAddress;

    private String teacherEmail;
}
