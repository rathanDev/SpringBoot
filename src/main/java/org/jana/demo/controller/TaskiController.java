package org.jana.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.logging.Logger;

public class TaskiController {

}

@Entity
@Table(name = "task")
class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private Long priority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
}

@RestController
@RequestMapping("/tasks")
class TaskController {
    private static Logger log = Logger.getLogger("Solution");
    // log.info("You can use 'log' for debug messages");

    @Autowired
    private TaskRepository taskRepository;

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody TaskData taskData) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorInfo("Cannot find task with given id", HttpStatus.NOT_FOUND.value()));
        }

        if (taskData.getDescription() == null || taskData.getDescription().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorInfo("Task description is required", HttpStatus.BAD_REQUEST.value()));
        }

        task.setDescription(taskData.getDescription());
        task.setPriority(taskData.getPriority());

        Task updated = taskRepository.save(task);

        return ResponseEntity.ok(taskData);
    }

}

@Repository
interface TaskRepository extends JpaRepository<Task, Long> {

}

class TaskData {

    private String description;
    private long priority;

    public TaskData() {
    }

    public TaskData(String description, long priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }
}

class ErrorInfo {

    private String message;
    private int status;

    public ErrorInfo() {
    }

    public ErrorInfo(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}