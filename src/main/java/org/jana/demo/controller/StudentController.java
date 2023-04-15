package org.jana.demo.controller;

import org.jana.demo.data.JpaStudent;
import org.jana.demo.exception.StudentNotFoundException;
import org.jana.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        String greet = studentService.greet();
        return ResponseEntity.status(HttpStatus.OK).body(greet);
    }

    @PostMapping
    public ResponseEntity<JpaStudent> create(@RequestBody JpaStudent student) {
        JpaStudent saved = studentService.create(student);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        // return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        return ResponseEntity.created(location).body(saved);
    }

    @PostMapping("/v2")
    public ResponseEntity<JpaStudent> createV2(@Valid @RequestBody JpaStudent student) {
        JpaStudent saved = studentService.create(student);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        // return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        return ResponseEntity.created(location).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JpaStudent> getById(@PathVariable long id) {
        Optional<JpaStudent> opt = studentService.findById(id);
        if (opt.isEmpty()) {
            // return ResponseEntity.status(HttpStatus.OK).body(null);
            throw new StudentNotFoundException("Gone id:" + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(opt.get());
    }

    @GetMapping
    public ResponseEntity<List<JpaStudent>> getById(@RequestParam String name) {
        List<JpaStudent> list = studentService.getByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        studentService.deleteById(id);
    }

//    @GetMapping("/exception")
//    public ResponseEntity<Student> get() {
//        return null;
//    }

}
