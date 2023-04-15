package org.jana.basic.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "department")
public class JpaDepartment {

    @Id
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "student")
//    @JsonIgnore
//    private List<JpaStudent> students;

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

//    public List<JpaStudent> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<JpaStudent> students) {
//        this.students = students;
//    }
}
