package com.example.demo.controller;

import com.example.demo.producer.KafkaProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducer producer;

    public KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestParam String message) {
        producer.sendMessage(topic, message);
        return "Message sent: " + message;
    }
}
