package com.jemalab.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    private final @Qualifier("FirstQueue") Queue firstQueue;
    private final @Qualifier("secondQueue") Queue secondQueue;
    private static final String ROUTING_KEY_TO_FIRST = "TO-FIRST-QUEUE";
    private static final String ROUTING_KEY_TO_SECOND = "TO-SECOND-QUEUE";


    public DirectConfig(Queue firstQueue, Queue secondQueue) {
        this.firstQueue = firstQueue;
        this.secondQueue = secondQueue;
    }

    @Bean
    public Exchange directExchange(){
        return ExchangeBuilder.directExchange("DIRECT-EXCHANGE-BASIC")
                .durable(true)
                .build();
    }

    @Bean
    public Binding firstDirectBinding(){
        return BindingBuilder.bind(firstQueue).to(directExchange()).with(ROUTING_KEY_TO_FIRST).noargs();
    }

    @Bean
    public Binding secondDirectBinding(){
        return BindingBuilder.bind(secondQueue).to(directExchange()).with(ROUTING_KEY_TO_SECOND).noargs();
    }
}
