package org.jana.demo;

import org.jana.demo.data.JpaStudent;
import org.jana.demo.repo.StudentRepo;
import org.jana.demo.service.DepartmentService;
import org.jana.demo.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    @Mock
    private DepartmentService departmentService;

    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    public void init() {
        JpaStudent student = new JpaStudent();
        Optional<JpaStudent> studentOpt = Optional.of(student);
        when(studentRepo.findById(1L)).thenReturn(studentOpt);
    }

    @Test
    public void testNull() {
        assertThat(studentService).isNotNull();
        int sum = studentService.add(3, 2);
        System.out.println("sum = " + sum);
        assertThat(sum).isEqualTo(5);
    }

    @Test
    public void testThis() {

    }

    @AfterEach
    public void wrapUp() {

    }

}
