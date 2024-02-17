package com.ontariotechu.sofe3980U;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "111").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

    @Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "111").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    @Test
    public void shouldReturnCorrectBinaryForPositiveNumber() throws Exception {
        this.mvc.perform(get("/api/binary?number=2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.binary").value("10"));
    }

    @Test
    public void shouldReturnErrorForNonNumericInput() throws Exception {
        this.mvc.perform(get("/api/binary?number=abc"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Input is not a valid number"));
    }

    @Test
    public void shouldReturnCorrectBinaryForNegativeNumber() throws Exception {
        this.mvc.perform(get("/api/binary?number=-5"))
                .andExpect(status().isOk())
                // Update "your-expected-binary-result-for-negative" to the actual expected result for -5 in your application logic
                .andExpect(jsonPath("$.binary").value("your-expected-binary-result-for-negative"));
    }
}
