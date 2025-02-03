package org.example.thanos_world.heros;

import org.example.thanos_world.superpowers.Superpower;
import org.example.thanos_world.weaknesses.Weakness;

import java.util.ArrayList;
import java.util.List;


public abstract class Hero {
    private final String name;
    private final List<Superpower> superpowers;
    private final List<Weakness> weaknesses;

    public Hero(String name) {
        this.name = name;
        this.superpowers = new ArrayList<>();
        this.weaknesses = new ArrayList<>();
    }

    // Getters (no setters for final fields)
    public String getName() {
        return name;
    }

    public List<Superpower> getSuperpowers() {
        return new ArrayList<>(superpowers); // Return a copy for immutability
    }

    public List<Weakness> getWeaknesses() {
        return new ArrayList<>(weaknesses); // Return a copy for immutability
    }

    // Methods to add/remove powers and weaknesses
    public void addPower(Superpower power) {
        superpowers.add(power);
    }

    public void removePower(Superpower power) {
        superpowers.remove(power);
    }

    public void addWeakness(Weakness weakness) {
        weaknesses.add(weakness);
    }

    public void removeWeakness(Weakness weakness) {
        weaknesses.remove(weakness);
    }

    // Abstract method for hero-specific actions
    public abstract void useSignatureAbility();
}
