package com.sarpio.userservice.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Departments {

    private Long departmentId;
    private String departmentName;
    private String departmentCode;
}
