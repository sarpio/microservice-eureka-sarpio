package com.sarpio.userservice.service;

import com.sarpio.userservice.controller.dto.Departments;
import com.sarpio.userservice.controller.dto.ResponseTemplateDTO;
import com.sarpio.userservice.entity.Users;
import com.sarpio.userservice.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository userRepository;
    private final RestTemplate restTemplate;

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public Users findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("No User with ID: " + userId));
    }

    // spring calls after the initialization of bean properties
    @PostConstruct
    private void initDb() {
        Users user1 = new Users();
        Users user2 = new Users();
        user1.setDepartmentId(1L);
        user1.setEmail("adam.stones@email.com");
        user1.setFirstName("Adam");
        user1.setLastName("Stones");
        user2.setDepartmentId(2L);
        user2.setEmail("john.steel@email.com");
        user2.setFirstName("John");
        user2.setLastName("Steel");
        userRepository.save(user1);
        userRepository.save(user2);
    }

    public ResponseTemplateDTO findUserWithDepartment(Long userId) {
        ResponseTemplateDTO dto = new ResponseTemplateDTO();
        Users user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("No User with ID: " + userId));
        Departments department = restTemplate.getForObject("http://localhost:8081/departments/" + user.getDepartmentId(), Departments.class);
        dto.setUsers(user);
        dto.setDepartments(department);
        return dto;
    }
}
