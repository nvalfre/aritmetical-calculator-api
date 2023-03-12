package com.nv.aritmeticalcalculatorapi.services;

import com.nv.aritmeticalcalculatorapi.domain.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserByUsername(String username);

    User saveUser(User user);

}
