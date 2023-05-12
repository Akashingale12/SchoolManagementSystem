package com.schoolmanagementsystem.model.ui;

import lombok.Data;

import java.util.List;

@Data
public class ListUserResponseDTO {
    List<UserResponseDTO> userResponseDTOList;
}
