package com.example.multiprojectmain.application.command.request.message;

import com.example.multiprojectmain.domain.message.Message;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class CreateMessageRequest {

    private final String message;

    public Message createNewMessage() {
        return Message.createMessage(message);
    }

}
