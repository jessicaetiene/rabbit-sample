package com.jemalab.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    private final @Qualifier("FirstQueue")  Queue firstQueue;
    private final @Qualifier("secondQueue") Queue secondQueue;

    public FanoutConfig(Queue firstQueue, Queue secondQueue) {
        this.firstQueue = firstQueue;
        this.secondQueue = secondQueue;
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return ExchangeBuilder.fanoutExchange("FANOUT-EXCHANGE-BASIC")
                .durable(true)
                .build();
    }

    @Bean
    public Binding firstFanoutBinding(){
        return BindingBuilder.bind(firstQueue).to(fanoutExchange());
    }

    @Bean
    public Binding secondFanoutBinding(){
        return BindingBuilder.bind(secondQueue).to(fanoutExchange());
    }
}
