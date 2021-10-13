package com.company.api;

import com.company.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ResourceController {

    @Value("${kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, MessageDto> kafkaTemplate;

    @PostMapping
    public void sendMessage(@RequestBody MessageDto dto){
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), dto);

    }

}
