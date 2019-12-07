package com.example.multiprojectmain.application.query.response.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class MessageQueryResponse {

    private final List<Record> messages;

    @Data
    @RequiredArgsConstructor(staticName = "of")
    public static class Record {
        private final String message;
    }

}
