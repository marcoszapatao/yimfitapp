package com.mezo.yimfit.app.yimfitapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mezo.yimfit.app.yimfitapp.entities.Users;
import com.mezo.yimfit.app.yimfitapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Users> findAll() {
        return (List<Users>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Users> findById(Long id) {

        return repository.findById(id);
    }

    @Transactional
    @Override
    public Users save(Users user) {

        return repository.save(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    
}
