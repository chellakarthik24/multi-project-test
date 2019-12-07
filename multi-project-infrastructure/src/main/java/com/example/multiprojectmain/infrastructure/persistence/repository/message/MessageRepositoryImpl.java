package com.example.multiprojectmain.infrastructure.persistence.repository.message;

import com.example.multiprojectmain.domain.message.Message;
import com.example.multiprojectmain.domain.message.MessageFactory;
import com.example.multiprojectmain.domain.message.MessageRepository;
import com.example.multiprojectmain.infrastructure.persistence.doma.dao.MessageInformationDao;
import com.example.multiprojectmain.infrastructure.persistence.doma.entity.MessageInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MessageRepositoryImpl implements MessageRepository {

    private final MessageInformationDao messageInformationDao;

    private final MessageFactory messageFactory;

    @Override
    public Optional<Message> getMessage(Integer id) {
        final MessageInformation messageInformation = messageInformationDao.selectById(id);
        if (messageInformation == null) {
            return Optional.empty();
        }
        return Optional.of(messageFactory.reconstract(messageInformation));
    }

    @Override
    public Message createMessage(Message message) {
        final MessageInformation messageInformation = new MessageInformation();
        messageInformation.setMessage(message.getMessageString());
        int count = messageInformationDao.insert(messageInformation);
        if (count != 1) {
            throw new RuntimeException("メッセージの登録に失敗しました。");
        }
        return message;
    }

    @Override
    public void updateMessage(Message message) {
        final MessageInformation messageInformation = messageInformationDao.selectById(message.getId());
        if (messageInformation == null) {
            throw new RuntimeException("更新対象のメッセージがありません。id=" + message.getId());
        }
        messageInformation.setMessage(message.getMessageString());
        int count = messageInformationDao.update(messageInformation);
        if (count != 1) {
            throw new RuntimeException("メッセージの更新に失敗しました。id=" + message.getId());
        }
    }

}
