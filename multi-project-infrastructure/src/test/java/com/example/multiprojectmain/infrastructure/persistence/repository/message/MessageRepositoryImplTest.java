package com.example.multiprojectmain.infrastructure.persistence.repository.message;

import com.example.multiprojectmain.TestInfrastructureApplication;
import com.example.multiprojectmain.domain.message.Message;
import com.example.multiprojectmain.domain.message.MessageRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestInfrastructureApplication.class)
class MessageRepositoryImplTest {

    @Resource
    MessageRepository messageRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test() {
        Optional<Message> messageResponse = messageRepository.getMessage(1);
        assertTrue(messageResponse::isPresent);
    }

}
