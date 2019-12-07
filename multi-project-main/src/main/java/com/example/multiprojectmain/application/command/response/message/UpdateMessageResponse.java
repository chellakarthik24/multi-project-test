package com.example.multiprojectmain.application.command.response.message;

import com.example.multiprojectmain.domain.message.Message;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class UpdateMessageResponse {

    private final Integer id;

    private final String message;

}
