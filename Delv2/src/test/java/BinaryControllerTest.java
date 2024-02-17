package com.ontariotechu.sofe3980U;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BinaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getDefault() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", ""))
                .andExpect(model().attribute("operand1Focused", false));
    }

    @Test
    public void getParameter() throws Exception {
        this.mockMvc.perform(get("/").param("operand1", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "111"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter() throws Exception {
        this.mockMvc.perform(post("/").param("operand1", "111").param("operator", "+").param("operand2", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "111"));
    }

    @Test
    public void shouldReturnBinaryForPositiveNumber() throws Exception {
        this.mockMvc.perform(get("/calculate?number=5"))
                .andExpect(status().isOk())
                .andExpect(content().string("101"));
    }

    @Test
    public void shouldHandleInvalidInputGracefully() throws Exception {
        this.mockMvc.perform(get("/calculate?number=abc"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid input"));
    }

    @Test
    public void shouldReturnBinaryForMaxInteger() throws Exception {
        this.mockMvc.perform(get("/calculate?number=2147483647"))
                .andExpect(status().isOk())
                .andExpect(content().string("1111111111111111111111111111111"));
    }
}
