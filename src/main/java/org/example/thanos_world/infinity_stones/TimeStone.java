package org.example.thanos_world.infinity_stones;

import org.example.thanos_world.heros.Hero;

public class TimeStone extends InfinityStone {
    public TimeStone(Hero guardian, String location) {
        super("Time Stone", "Time Travel", guardian, location);
    }

    @Override
    public void unleashPower() {
        System.out.println("TIME BENDS! The Time Stone rewinds the clock.");
    }
}
