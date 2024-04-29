package com.ssafy.ssafit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.annotation.WebServlet;

@RestController
@WebServlet("/api-user")
@Tag(name="UserRestController", description = "유저")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    
    
    // 사용자 로그인
    @PostMapping("/user/login")
    @Operation(summary = "로그인")
    public ResponseEntity<?> login(String id,String password ){
        User tmp = userService.getUser(id);
        if(tmp.getId().equals(id) && tmp.getPassword().equals(password)) {
            userService.logIn(tmp.getId());
            return new ResponseEntity<User>(tmp, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    
    // 사용자 로그아웃
    @GetMapping("/user/logout")
    @Operation(summary = "로그아웃")
    public ResponseEntity<?> logout(String id){
        userService.logOut(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    // 사용자 등록
    @PostMapping("/user")
    @Operation(summary = "회원가입")
    public ResponseEntity<?> signup(@ModelAttribute User user){
        userService.signup(user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    
    
    

}
