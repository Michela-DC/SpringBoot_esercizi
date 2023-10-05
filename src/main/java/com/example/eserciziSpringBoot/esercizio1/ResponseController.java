package com.example.eserciziSpringBoot.esercizio1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/esercizio1-response")
public class ResponseController {
    @GetMapping(value = "/info")
    public ResponseEntity<String> responseOK () {
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/random")
    public ResponseEntity<String> response() {
        if(new Random().nextBoolean()) {
            return ResponseEntity.ok("It's true");
        } else {
            return ResponseEntity.badRequest().body("It's false");
        }
    }
}
