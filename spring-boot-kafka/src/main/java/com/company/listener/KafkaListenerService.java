package com.company.listener;

import com.company.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaListenerService {

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${kafka.group.id}"
    )
    public void listen(@Payload MessageDto dto) {
        log.info("Message received.. MessageID : {} Message: {} Date : {}",
                dto.getUuid(),
                dto.getMessage(),
                dto.getDate());
    }
}
