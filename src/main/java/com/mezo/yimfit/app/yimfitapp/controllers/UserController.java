package com.mezo.yimfit.app.yimfitapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mezo.yimfit.app.yimfitapp.entities.Users;
import com.mezo.yimfit.app.yimfitapp.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<Users> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Users> userOptional = service.findById(id);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody Users user){
        Users userNew = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> update (@PathVariable Long id, @RequestBody Users user) {
        Users userNew = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userNew);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
      service.deleteById(id);
    }
}
