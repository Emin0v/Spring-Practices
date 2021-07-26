package com.company;

import com.company.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitApplication {

    @Autowired
    private NotificationProducer notificationProducer;

    public static void main(String[] args) {
        SpringApplication.run(RabbitApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner commandLineRunner = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                while (true) {
                    Thread thread = new Thread(notificationProducer);
                    thread.sleep(8000);
                    thread.start();
                }
            }
        };
        return commandLineRunner;
    }

}
