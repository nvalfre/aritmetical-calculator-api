package com.nv.aritmeticalcalculatorapi.services;


import com.nv.aritmeticalcalculatorapi.domain.dto.LoginRequestDTO;
import com.nv.aritmeticalcalculatorapi.domain.dto.LoginResponseDTO;

public interface LoginService {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO) throws Exception;
}
