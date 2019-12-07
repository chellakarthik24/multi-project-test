package com.example.multiprojectmain.application.command.service.message;

import com.example.multiprojectmain.application.command.request.message.CreateMessageRequest;
import com.example.multiprojectmain.application.command.request.message.UpdateMessageRequest;
import com.example.multiprojectmain.application.command.response.message.CreateMessageResponse;
import com.example.multiprojectmain.application.command.response.message.UpdateMessageResponse;
import com.example.multiprojectmain.domain.message.Message;
import com.example.multiprojectmain.domain.message.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageCommandService {

    private final MessageRepository messageRepository;

    public CreateMessageResponse createMessage(CreateMessageRequest request) {
        final Message message = request.createNewMessage();
        final Message newMessage = messageRepository.createMessage(message);
        return CreateMessageResponse.of(newMessage);
    }

    public UpdateMessageResponse getUpdateMessage(Integer id) {
        final Message originalMessage = messageRepository.getMessage(id)
                .orElseThrow(() -> new RuntimeException("更新メッセージが見つかりません。id=" + id));
        return UpdateMessageResponse.of(id, originalMessage.getMessageString());
    }


    public void updateMessage(UpdateMessageRequest request) {
        final Message originalMessage = messageRepository.getMessage(request.getId())
                .orElseThrow(() -> new RuntimeException("更新メッセージが見つかりません。id=" + request.getId()));
        final Message updateMessage = request.createUpdateMessage(originalMessage);
        messageRepository.updateMessage(updateMessage);
    }

}
