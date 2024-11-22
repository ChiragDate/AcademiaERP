package com.chirag.festaurant.academiaerp.Controller;


import com.chirag.festaurant.academiaerp.Service.SalaryService;
import com.chirag.festaurant.academiaerp.dto.LoginRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class LoginController {

    private final SalaryService service;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginrequest) {
        return ResponseEntity.ok(service.loginApi(loginrequest));
    }
}
