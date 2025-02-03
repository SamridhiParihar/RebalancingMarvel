package org.example.thanos_world.infinity_stones;

import org.example.thanos_world.heros.Hero;

public class SpaceStone extends InfinityStone {
    public SpaceStone(Hero guardian, String location) {
        super("Space Stone", "Teleportation", guardian, location);
    }

    @Override
    public void unleashPower() {
        System.out.println("WHOOSH! The Space Stone warps reality.");
    }
}
