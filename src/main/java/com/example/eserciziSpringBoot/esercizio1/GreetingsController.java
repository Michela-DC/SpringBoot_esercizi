package com.example.eserciziSpringBoot.esercizio1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/esercizio1-greetings")
public class GreetingsController {
    @GetMapping(value = "/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping(value = "/greeting")
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("Good Afternoon!", HttpStatus.OK);
    }
}
