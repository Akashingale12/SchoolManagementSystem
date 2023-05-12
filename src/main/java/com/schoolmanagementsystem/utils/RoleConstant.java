package com.schoolmanagementsystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum RoleConstant {
    TEACHER("Teacher"), ADMIN("Admin"), STUDENT("Student");
    public String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
