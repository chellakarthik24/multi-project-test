package com.example.multiprojectmain.infrastructure.persistence.queryservice.message;

import com.example.multiprojectmain.application.query.response.message.MessageQueryResponse;
import com.example.multiprojectmain.application.query.service.message.MessageQueryService;
import com.example.multiprojectmain.infrastructure.persistence.doma.dao.MessageInformationDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageQueryServiceImpl implements MessageQueryService {

    private final MessageInformationDao messageInformationDao;

    @Override
    public MessageQueryResponse getMessageList() {
        final List<MessageQueryResponse.Record> testQueryResponses = messageInformationDao.selectAll().stream()
                .map(messageInformation -> MessageQueryResponse.Record.of(messageInformation.getMessage()))
                .collect(Collectors.toList());
        return MessageQueryResponse.of(testQueryResponses);
    }

}
