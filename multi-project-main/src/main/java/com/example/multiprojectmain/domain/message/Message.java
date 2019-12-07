package com.example.multiprojectmain.domain.message;

import lombok.Getter;

public class Message {

    @Getter
    private Integer id;

    @Getter
    private String messageString;

    private Message() {}

    Message(Integer id, String messageString) {
        this.id = id;
        this.messageString = messageString;
    }

    public static Message createMessage(String messageString) {
        final Message message = new Message();
        message.messageString = messageString;
        return message;
    }

    public Message updateMessage(String newMessageString) {
        return new Message(id, newMessageString);
    }

}
