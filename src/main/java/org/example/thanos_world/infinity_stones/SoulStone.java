package org.example.thanos_world.infinity_stones;

import org.example.thanos_world.heros.Hero;

public class SoulStone extends InfinityStone {
    public SoulStone(Hero guardian, String location) {
        super("Soul Stone", "Soul Manipulation", guardian, location);
    }

    @Override
    public void unleashPower() {
        System.out.println("SOULS TREMBLE! The Soul Stone reveals all living beings.");
    }
}
