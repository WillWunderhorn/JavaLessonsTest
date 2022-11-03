package ru.horn.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.horn.spring.Stuff.StuffExample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    //    public static List<StuffExample> list = new ArrayList();
    public static String users[] = {"Tom", "Max", "Jack"};
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
