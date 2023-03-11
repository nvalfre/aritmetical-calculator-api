package com.nv.aritmeticalcalculatorapi.controllers;

import com.nv.aritmeticalcalculatorapi.domain.dto.LoginRequestDTO;
import com.nv.aritmeticalcalculatorapi.domain.dto.LoginResponseDTO;
import com.nv.aritmeticalcalculatorapi.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
        return loginService.login(loginRequestDTO);
    }
    @GetMapping("/")
    public String welcome() {
        return "Welcome :)";
    }

}
