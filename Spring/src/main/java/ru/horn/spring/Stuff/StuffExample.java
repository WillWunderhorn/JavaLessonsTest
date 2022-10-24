package ru.horn.spring.Stuff;

import java.util.ArrayList;

public class StuffExample extends ArrayList<StuffExample> {
    String name;
    int id;

    public StuffExample(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
