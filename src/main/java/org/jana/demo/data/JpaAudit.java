package org.jana.demo.data;


import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class JpaAudit {

    private LocalDate createdDate;
    private LocalDate modifiedDate;

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
