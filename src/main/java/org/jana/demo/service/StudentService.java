package org.jana.demo.service;

import org.jana.demo.config.MessageConfig;
import org.jana.demo.data.JpaStudent;
import org.jana.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private MessageConfig messageConfig;

    @Autowired
    private MessageSource messageSource;        // a strategy interface

    public String greet() {
        Locale locale = LocaleContextHolder.getLocale();
        String message = messageSource.getMessage("good.morning.message", null, "Default Message", locale);
        return message;
    }

    public JpaStudent create(JpaStudent student) {
        student.setCreatedDate(LocalDate.now());
        student.setModifiedDate(LocalDate.now());
        JpaStudent saved = studentRepo.save(student);
        return saved;
    }

    public Optional<JpaStudent> findById(long id) {
        String messageType = messageConfig.getMessageType();
        System.out.println("messageType = " + messageType);
        Optional<JpaStudent> studentOpt = studentRepo.findById(id);
        return studentOpt;
    }

    public List<JpaStudent> getByName(String name) {
        List<JpaStudent> list = studentRepo.findByName(name);
        return list;
    }

    public void deleteById(long id) {
        studentRepo.deleteById(id);
    }

    public int add(int a, int b) {
        return a + b;
    }

}
