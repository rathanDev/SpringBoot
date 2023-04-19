package org.jana.demo.mapper;

import org.jana.demo.data.TransactionData;
import org.jana.demo.jpa.JpaTransaction;

public interface TransactionMapper {

    static JpaTransaction mapToJpa(TransactionData d) {
        JpaTransaction jpa = new JpaTransaction();
        jpa.setAmount(d.getAmount());
        return jpa;
    }

    static TransactionData mapToData(JpaTransaction jpa) {
        TransactionData data = new TransactionData();
        data.setId(jpa.getId());
        data.setAmount(jpa.getAmount());
        return data;
    }

    static void updateJpa(TransactionData data, JpaTransaction jpa) {
        jpa.setAmount(data.getAmount());
    }

}
