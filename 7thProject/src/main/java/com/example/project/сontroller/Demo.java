package com.example.project.сontroller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Demo {
//    UserService userService;

    @GetMapping
    public ResponseEntity<String> home(){
        return ResponseEntity.ok().body("Home...");
    }
//    @PostMapping("/auth")
//    public ResponseEntity<String> auth(@RequestBody Request request) throws Exception {
//        return userService.authenticate(request);
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody Request request) throws Exception{
//        return userService.register(request);
//    }

}
