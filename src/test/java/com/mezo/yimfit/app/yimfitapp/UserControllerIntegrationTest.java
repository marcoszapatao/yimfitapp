package com.mezo.yimfit.app.yimfitapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
        @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUsers() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").isNotEmpty());
    }

    @Test
    public void testCreateUser() throws Exception {
        String newUserJson = "{\"name\": \"Test User\"}";

        mockMvc.perform(post("/api/users")
                .contentType("application/json")
                .content(newUserJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Test User"));
    }
}
