package org.example.to_be_snapped.components;


public class InfinityStone {
    String name;
    String power;
    Location location;
    public Hero guardianHero;

    public InfinityStone(String name, String power, Location location, Hero guardianHero) {
        this.name = name;
        this.power = power;
        this.location = location;
        this.guardianHero = guardianHero;
    }

    public void displayInfo() {
        System.out.println("Infinity Stone: " + name);
        System.out.println("Power: " + power);
        System.out.println("Location: " + location.name);
        System.out.println("Guardian Hero: " + guardianHero.name);
        System.out.println();
    }
}
