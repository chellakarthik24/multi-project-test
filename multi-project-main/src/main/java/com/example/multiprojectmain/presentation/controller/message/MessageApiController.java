package com.example.multiprojectmain.presentation.controller.message;

import com.example.multiprojectmain.application.query.response.message.MessageQueryResponse;
import com.example.multiprojectmain.application.query.service.message.MessageQueryService;
import com.example.multiprojectmain.presentation.response.message.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class MessageApiController {

    private final MessageQueryService messageQueryService;

    @GetMapping
    public ResponseEntity<MessageResponse> index() {
        final MessageQueryResponse messageQueryResponse = messageQueryService.getMessageList();
        final MessageResponse messageResponse = MessageResponse.of(messageQueryResponse);
        return ResponseEntity.ok(messageResponse);
    }

}
