package com.mezo.yimfit.app.yimfitapp.services;

import java.util.List;
import java.util.Optional;

import com.mezo.yimfit.app.yimfitapp.entities.Users;

public interface UserService {

    List<Users> findAll();
    Optional<Users> findById(Long id);
    Users save(Users user);
    void deleteById(Long id);
}
