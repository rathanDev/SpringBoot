package org.jana.demo.data;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class JpaStudent extends JpaAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50, message = "Name should not have more than 50 characters")
    private String name;

    private String email;

    @Past(message = "Birthdate should be in past")
    private LocalDate dob;

    @ManyToOne(fetch = FetchType.LAZY)
    private JpaDepartment department;

    public JpaStudent() {
    }

    public JpaStudent(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public JpaDepartment getDepartment() {
        return department;
    }

    public void setDepartment(JpaDepartment department) {
        this.department = department;
    }
}
