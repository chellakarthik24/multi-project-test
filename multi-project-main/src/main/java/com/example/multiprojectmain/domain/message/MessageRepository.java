package com.example.multiprojectmain.domain.message;

import java.util.Optional;

public interface MessageRepository {

    Optional<Message> getMessage(Integer id);

    Message createMessage(Message message);

    void updateMessage(Message message);

}
