package com.sarpio.userservice.controller.dto;

import com.sarpio.userservice.entity.Users;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseTemplateDTO {

    private Users users;
    private Departments departments;
}
