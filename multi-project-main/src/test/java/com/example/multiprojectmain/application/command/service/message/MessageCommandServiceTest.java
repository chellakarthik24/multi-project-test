package com.example.multiprojectmain.application.command.service.message;

import com.example.multiprojectmain.TestMainApplication;
import com.example.multiprojectmain.application.command.response.message.UpdateMessageResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestMainApplication.class)
class MessageCommandServiceTest {

    @Resource
    MessageCommandService messageCommandService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test() {
        UpdateMessageResponse response = messageCommandService.getUpdateMessage(1);
        assertEquals("こんにちは。", response.getMessage());
    }

}
