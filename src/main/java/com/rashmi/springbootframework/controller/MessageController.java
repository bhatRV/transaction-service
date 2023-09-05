package com.rashmi.springbootframework.controller;

import com.rashmi.springbootframework.dto.MessageRequest;
import com.rashmi.springbootframework.dto.events.DataMessage;
import com.rashmi.springbootframework.service.EventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/services/messages")
public class MessageController {

    private final EventProducer eventProducer;

    @Autowired
    public MessageController(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    @PostMapping()
    public ResponseEntity<Void> sendMessage(@RequestBody MessageRequest message) {
        eventProducer.sendMessage(new DataMessage(UUID.randomUUID().toString(), message.getMessage()));
        return ResponseEntity.ok().build();
    }

}