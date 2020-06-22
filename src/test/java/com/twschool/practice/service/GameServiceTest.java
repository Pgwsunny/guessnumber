package com.twschool.practice.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class GameServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_result_when_guess_number() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/games/guess-numbers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"number\":\"1 2 3 4\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.input").value("1 2 3 4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("4A0B"));

    }
}
