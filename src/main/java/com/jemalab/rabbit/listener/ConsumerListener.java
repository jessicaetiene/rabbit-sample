package com.jemalab.rabbit.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"SECOND-QUEUE-BASIC"})
public class ConsumerListener {


    @RabbitHandler
    public void execute(String message){
        System.out.println("******" + message + "******");
    }
}



//Anotação que marca um método para ser o destino de um ouvinte de mensagem do
//Rabbit dentro de uma classe anotada com RabbitListener.