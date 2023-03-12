package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.config.JwtUtil;
import com.nv.aritmeticalcalculatorapi.domain.dto.LoginRequestDTO;
import com.nv.aritmeticalcalculatorapi.domain.dto.LoginResponseDTO;
import com.nv.aritmeticalcalculatorapi.domain.entity.User;
import com.nv.aritmeticalcalculatorapi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class LoginServiceImplTest {
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtUtil jwtUtil;
    @Mock
    private UserRepository userRepository;
    @Mock
    private Authentication auth;

    @InjectMocks
    private LoginServiceImpl loginService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLogin() throws Exception {
        User user = new User();
        user.setActive(true);

        when(userRepository.findByUsername(any())).thenReturn(Optional.of(user));
        when(authenticationManager.authenticate(any())).thenReturn(auth);
        when(jwtUtil.generateToken(any())).thenReturn("authToken");

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setName("nv");

        LoginResponseDTO login = loginService.login(loginRequestDTO);

        assertNotNull(login);
    }

}