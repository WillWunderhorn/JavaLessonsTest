package ru.horn.spring.controller;

//Дз: создать Spring Boot сервис в котором реализованы все 5 методов get post put patch delete
//все методы должны быть проброшены в сервис с аннотацией service

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static ru.horn.spring.Application.users;


@Service
@RestController
public class Controller {

    @Bean
    @RequestMapping("/get")
    public String[] findAll() {
        return users;
    }

    @RequestMapping("/put/{id}/{name}")
    public String createStuff(@PathVariable int id, @PathVariable String name) {
        ArrayList<String> usersArray = new ArrayList<>();
        for (String i: users) {
            usersArray.add(i);
        }
        usersArray.set(id, name);
        return usersArray + "  Selected:  " + usersArray.get(id) + " id: " + id + " replaced by: " + name;
    }

    @RequestMapping("/post/{name}")
    public ArrayList<String> updateStuff(@PathVariable(value = "name") String newName) {
        ArrayList<String> usersArray = new ArrayList<>();
        for (String i: users) {
            usersArray.add(i);
        }
        usersArray.add(newName);
        return usersArray;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStuff(@PathVariable(value = "id") int delName) {
        ArrayList<String> usersArray = new ArrayList<>();
        for (String i: users) {
            usersArray.add(i);
        }
        usersArray.remove(delName);
        return usersArray.get(delName) + " Was removed( ";
    }
}
