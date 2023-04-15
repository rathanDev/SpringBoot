package org.jana.demo;

import org.jana.demo.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = DemoApplication.class)
public class IntegrationTest {


    @Autowired
    private MockMvc mvc;

    @Autowired
    private StudentService studentService;

    @BeforeEach
    void init() {

    }

    @Test
    void test() {
        assertEquals(1, 1);
    }

}
