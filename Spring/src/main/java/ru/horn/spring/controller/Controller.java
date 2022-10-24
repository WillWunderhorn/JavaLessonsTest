package ru.horn.spring.controller;

//Дз: создать Spring Boot сервис в котором реализованы все 5 методов get post put patch delete
//все методы должны быть проброшены в сервис с аннотацией service

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.horn.spring.Application;
import ru.horn.spring.Stuff.StuffExample;

import java.util.List;


@Service
@RestController
public class Controller {

    @Bean
    @RequestMapping("/get")
    public List<StuffExample> findAll() {
        return Application.findAll();
    }


    @GetMapping("/get/{id}")
    public List<StuffExample> findStuffByName(@PathVariable(value = "id")int stuffId) throws ConfigDataResourceNotFoundException {
        StuffExample stuffExample = (StuffExample) Application.findById(stuffId);
        return stuffExample;
    }

    @RequestMapping("/put")
    public String createStuff(){
        return "Stuff was created";
    }

    @RequestMapping("/post")
    public String updateStuff(){
        return "Stuff was updated";
    }

    @RequestMapping("/delete")
    public String deleteStuff(){
        return "Stuff was deleted";
    }
}
