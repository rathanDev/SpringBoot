package org.jana.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @GetMapping("/greet")
    public ResponseEntity<Object> greet() {
        return ResponseEntity.ok().body("Hello");
    }

//    @PostMapping("/create")
//    public ResponseEntity<Object> create() {
//
//    }

}
