package com.sarpio.userservice.controller;

import com.sarpio.userservice.config.GreetingsProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PropertyRestController {

    private final GreetingsProperties props;

    public PropertyRestController(GreetingsProperties props) {
        this.props = props;
    }

    @GetMapping("/hello")
    public String message() {
        return props.getMessage();
    }
}
