package org.example.thanos_world.infinity_stones;

import org.example.thanos_world.heros.Hero;

public class RealityStone extends InfinityStone {
    public RealityStone(Hero guardian, String location) {
        super("Reality Stone", "Reality Warping", guardian, location);
    }

    @Override
    public void unleashPower() {
        System.out.println("REALITY SHIFTS! The world bends to the wielder's will.");
    }
}
