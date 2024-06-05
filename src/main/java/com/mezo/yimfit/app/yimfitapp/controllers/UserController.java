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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "Operations pertaining to users in YimfitApp")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    @Operation(summary = "Get all users", description = "Returns a list of all users")
    public List<Users> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
        @Operation(summary = "Get user by ID", description = "Returns a single user by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Users.class))),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Users> userOptional = service.findById(id);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Creates a new user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "User created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Users.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    public ResponseEntity<Users> create(@RequestBody Users user){
        Users userNew = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userNew);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing user", description = "Updates an existing user by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User updated", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Users.class))),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    public ResponseEntity<Users> update (@PathVariable Long id, @RequestBody Users user) {
        Users userNew = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userNew);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user", description = "Deletes a user by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "User deleted"),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    public void delete(@PathVariable Long id){
      service.deleteById(id);
    }
}
