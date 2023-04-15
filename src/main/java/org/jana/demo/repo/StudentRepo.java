package org.jana.demo.repo;

import org.jana.demo.data.JpaStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<JpaStudent, Long> {

    List<JpaStudent> findByName(String name);

    Optional<JpaStudent> findById(long id);

}
