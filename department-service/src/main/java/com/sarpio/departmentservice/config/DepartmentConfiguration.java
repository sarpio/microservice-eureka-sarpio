package com.sarpio.departmentservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("limites")
public class DepartmentConfiguration {
    private int minimum;
    private int maximum;
}
