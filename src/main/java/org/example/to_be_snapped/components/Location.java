package org.example.to_be_snapped.components;

public class Location {
    String name;
    String description;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    void displayInfo() {
        System.out.println("Location: " + name);
        System.out.println("Description: " + description);
    }

}