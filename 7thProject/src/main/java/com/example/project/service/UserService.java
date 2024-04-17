//package com.example.project.service;
//
//
//import com.example.project.config.JwtUtils;
//import com.example.project.dto.Request;
//import com.example.project.entity.Role;
//import com.example.project.interfaces.UserInterface;
//import com.example.project.repository.UserRepository;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import com.example.project.entity.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
//public class UserService implements UserInterface {
//    UserRepository userRepository;
//    PasswordEncoder passwordEncoder;
//    AuthenticationManager authenticationManager;
//    JwtUtils jwtUtils;
//    @Override
//    public ResponseEntity<String> authenticate(Request request) throws Exception {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUsername(),
//                        request.getPassword())
//        );
//        final UserDetails userDetails = userRepository.findByUsername(request.getUsername());
//        if(userDetails != null){
//            return ResponseEntity.ok(jwtUtils.generateToken(userDetails));
//        }else{
//            throw new Exception("User not found");
//        }
//    }
//
//    @Override
//    public ResponseEntity<String> register(Request request) throws Exception {
//        if(userRepository.findByUsername(request.getUsername()) != null){
//            throw new Exception("User with " + request.getUsername() + " already exists");
//        }
//        User user = new User();
//        user.setUsername(request.getUsername());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setRole(Role.USER);
//
//        userRepository.save(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
//    }
//}
