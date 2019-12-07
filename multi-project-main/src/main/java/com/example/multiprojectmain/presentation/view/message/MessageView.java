package com.example.multiprojectmain.presentation.view.message;

import com.example.multiprojectmain.application.query.response.message.MessageQueryResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class MessageView {

    private final List<Message> messages;

    public Integer getMessageCount() {
        return messages.size();
    }

    @Getter
    @RequiredArgsConstructor
    public static class Message {
        private final String message;
    }

    public static MessageView of(MessageQueryResponse messageQueryResponse) {
        final List<Message> messages = messageQueryResponse.getMessages().stream()
                .map(message -> new Message(message.getMessage()))
                .collect(Collectors.toList());
        return new MessageView(messages);
    }

}
