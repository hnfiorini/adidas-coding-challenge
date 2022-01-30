package com.adidas.emailservice.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@EnableBinding(Sink.class)
public class EmailService {

    @StreamListener(Sink.INPUT)
    public void consume(Message message){
        log.info(String.format("$$ -> Consumed Message -> %s", message));
    }

    public static class Message{
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "message='" + message + '\'' +
                    '}';
        }
    }
}
