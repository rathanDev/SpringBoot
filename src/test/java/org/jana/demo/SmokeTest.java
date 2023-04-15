package org.jana.demo;

import org.jana.demo.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SmokeTest {

    @Autowired
    private StudentController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
        assertThat(mockMvc).isNotNull();
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc
                .perform(get("/student/greet"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello!")));
    }

    @Test
    public void testGetStudentById() throws Exception {
        this.mockMvc
                .perform(get("/student/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Jana")));
    }

}
