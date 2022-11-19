package ru.narushev.mockitaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockitaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockitaSpringApplication.class, args);
        YamlConf.Config.data();
        System.out.println("");
    }

}
