package com.example.multiprojectmain.domain.message;

import com.example.multiprojectmain.infrastructure.persistence.doma.entity.MessageInformation;
import org.springframework.stereotype.Component;

@Component
public class MessageFactory {

    public Message reconstract(MessageInformation messageInformation) {
        return new Message(messageInformation.getId(),
                messageInformation.getMessage());
    }

}
