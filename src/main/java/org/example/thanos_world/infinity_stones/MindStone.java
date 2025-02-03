package org.example.thanos_world.infinity_stones;

import org.example.thanos_world.heros.Hero;

public class MindStone extends InfinityStone {
    public MindStone(Hero guardian, String location) {
        super("Mind Stone", "Mind Control", guardian, location);
    }

    @Override
    public void unleashPower() {
        System.out.println("MINDS BOW! The Mind Stone dominates all thoughts.");
    }
}
