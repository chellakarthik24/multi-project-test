package com.example.multiprojectmain.application.command.request.message;

import com.example.multiprojectmain.domain.message.Message;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class UpdateMessageRequest {

    @Getter
    private final Integer id;

    private final String message;

    public Message createUpdateMessage(Message oldMessage) {
        return oldMessage.updateMessage(message);
    }

}
