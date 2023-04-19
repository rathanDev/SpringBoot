package org.jana.demo.controller;

import org.jana.demo.data.TransactionData;
import org.jana.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/greet")
    public ResponseEntity<Object> greet() {
        return ResponseEntity.ok().body("Hello");
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody TransactionData req) {
        TransactionData data = transactionService.create(req);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody TransactionData req) {
        TransactionData updated = transactionService.update(id, req);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
    }

}
