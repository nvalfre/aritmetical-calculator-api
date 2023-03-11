package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.config.JwtUtil;
import com.nv.aritmeticalcalculatorapi.domain.dto.LoginRequestDTO;
import com.nv.aritmeticalcalculatorapi.domain.dto.LoginResponseDTO;
import com.nv.aritmeticalcalculatorapi.domain.entity.User;
import com.nv.aritmeticalcalculatorapi.repository.UserRepository;
import com.nv.aritmeticalcalculatorapi.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) throws Exception {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDTO.getName(), loginRequestDTO.getPassword())
            );
            final String token = jwtUtil.generateToken(loginRequestDTO.getName());
            User byUserName = userRepository.findByUsername(loginRequestDTO.getName())
                    .orElseThrow(EntityNotFoundException::new);

            return LoginResponseDTO.builder()
                    .token(token)
                    .name(byUserName.getUsername())
                    .isActive(byUserName.isActive() && authenticate.isAuthenticated())
                    .build();
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
    }
}
