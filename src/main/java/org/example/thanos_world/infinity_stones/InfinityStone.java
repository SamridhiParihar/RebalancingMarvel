package org.example.thanos_world.infinity_stones;

import org.example.thanos_world.heros.Hero;

public abstract class InfinityStone {
    private final String name;
    private final String power;
    private  Hero guardian;
    private  String location;

    public InfinityStone(String name, String power, Hero guardian, String location) {
        this.name = name;
        this.power = power;
        this.guardian = guardian;
        this.location = location;
    }

    // Getters
    public String getName() { return name; }
    public String getPower() { return power; }
    public Hero getGuardian() { return guardian; }
    public String getLocation() { return location; }


    public abstract void unleashPower();

    public void setGuardian(Hero newGuardian) {
        this.guardian  = newGuardian;
    }
}
