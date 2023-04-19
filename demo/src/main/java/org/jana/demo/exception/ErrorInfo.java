package org.jana.demo.exception;

import java.time.LocalDateTime;

public class ErrorInfo {

    private LocalDateTime dateTime;
    private String message;
    private String desc;

    public ErrorInfo(LocalDateTime dateTime, String message, String desc) {
        super();
        this.dateTime = dateTime;
        this.message = message;
        this.desc = desc;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
