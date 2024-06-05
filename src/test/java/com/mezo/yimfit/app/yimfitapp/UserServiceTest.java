package com.mezo.yimfit.app.yimfitapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mezo.yimfit.app.yimfitapp.entities.Users;
import com.mezo.yimfit.app.yimfitapp.repositories.UserRepository;
import com.mezo.yimfit.app.yimfitapp.services.UserService;
import com.mezo.yimfit.app.yimfitapp.services.UserServiceImpl;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
       
    @InjectMocks
    private UserServiceImpl userServiceImpl;

    
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = userServiceImpl;
    }

    @Test
    public void testSaveUser() {
        Users user = new Users();
        user.setName("Test User");

        when(userRepository.save(any(Users.class))).thenReturn(user);

        Users created = userService.save(user);

        assertNotNull(created);
        assertEquals("Test User", created.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testFindById() {
        Users user = new Users();
        user.setId(1L);
        user.setName("Test User");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<Users> found = userService.findById(1L);

        assertTrue(found.isPresent());
        assertEquals("Test User", found.get().getName());
    }
}
