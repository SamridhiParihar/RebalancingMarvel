package org.example.thanos_world.infinity_stones;

import org.example.thanos_world.heros.Hero;

public class PowerStone extends InfinityStone {
    public PowerStone(Hero guardian, String location) {
        super("Power Stone", "Energy Manipulation", guardian, location);
    }

    @Override
    public void unleashPower() {
        System.out.println("BOOM! The Power Stone obliterates everything in its path.");
    }
}
