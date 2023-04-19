package org.jana.demo.service;

import org.jana.demo.data.TransactionData;
import org.jana.demo.exception.TransactionNotFoundException;
import org.jana.demo.jpa.JpaTransaction;
import org.jana.demo.mapper.TransactionMapper;
import org.jana.demo.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    public TransactionData create(TransactionData req) {
        JpaTransaction jpa = TransactionMapper.mapToJpa(req);
        JpaTransaction saved = transactionRepo.save(jpa);
        return TransactionMapper.mapToData(saved);
    }

    public TransactionData update(Long id, TransactionData req) {
        Optional<JpaTransaction> trxOpt = transactionRepo.findById(id);
        if (trxOpt.isEmpty()) {
            throw new TransactionNotFoundException("Transaction not found for id:" + id);
        }
        JpaTransaction jpa = trxOpt.get();
        TransactionMapper.updateJpa(req, jpa);
        JpaTransaction savedJpa = transactionRepo.save(jpa);
        return TransactionMapper.mapToData(savedJpa);
    }

}
