package com.jemalab.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    @Qualifier("FirstQueue")
    public Queue firstQueue(){
        return QueueBuilder.durable("FIRST-QUEUE-BASIC").build();
    }

    @Bean
    @Qualifier("secondQueue")
    public Queue secondQueue(){
        return QueueBuilder.durable("SECOND-QUEUE-BASIC").build();
    }
}
