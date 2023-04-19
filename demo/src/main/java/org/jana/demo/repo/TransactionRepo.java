package org.jana.demo.repo;

import org.jana.demo.jpa.JpaTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepo extends JpaRepository<JpaTransaction, Long> {

    Optional<JpaTransaction> findById(Long id);

}
