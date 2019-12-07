package com.example.multiprojectmain.application.command.response.message;

import com.example.multiprojectmain.domain.message.Message;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateMessageResponse {

    private final Integer id;

    private final String message;

    public static CreateMessageResponse of(Message message) {
        return new CreateMessageResponse(message.getId(), message.getMessageString());
    }

}
