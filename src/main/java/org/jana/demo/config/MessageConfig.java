package org.jana.demo.config;

public class MessageConfig {

    private boolean generateId;
    private String messageType;

    public boolean isGenerateId() {
        return generateId;
    }

    public void setGenerateId(boolean generateId) {
        this.generateId = generateId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

}
