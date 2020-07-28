package com.jemalab.rabbit.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exchanges")
public class ExchangeController {

    private final RabbitTemplate rabbitTemplate;


    public ExchangeController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("{exchange}/{routingKey}")
    public ResponseEntity<Void> postOnExchange(@PathVariable String exchange,
                                               @PathVariable String routingKey,
                                               @RequestBody String message){
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        return ResponseEntity.ok().build();
    }


    @PostMapping("json/{exchange}/{routingKey}")
    public ResponseEntity<Void> postJsonOnExchange(@PathVariable String exchange,
                                               @PathVariable String routingKey,
                                               @RequestBody String message){
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        return ResponseEntity.ok().build();
    }
}
