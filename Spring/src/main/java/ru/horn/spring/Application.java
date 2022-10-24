package ru.horn.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.horn.spring.Stuff.StuffExample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static List<StuffExample> list = new ArrayList();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        StuffExample ron = new StuffExample("Ron", 1);
        StuffExample vanessa = new StuffExample("Vanessa", 2);
        StuffExample mike = new StuffExample("Mike", 3);
        StuffExample jack = new StuffExample("Jack", 4);
        StuffExample jackass = new StuffExample("JackAss", 5);

        list.addAll(List.of(ron, vanessa, mike, jack, jackass));

    }

    public static List<StuffExample> findAll() {
        return list;
    }

    public static List<StuffExample> findById(int id) {
        for(StuffExample stuff: list){
            if(stuff.getId() == id){
                return stuff;
            }
        }
        Stream<StuffExample> suitablePerson = list.stream().filter(people -> people.getId() == id);
        return (List<StuffExample>) suitablePerson;
    }

}
