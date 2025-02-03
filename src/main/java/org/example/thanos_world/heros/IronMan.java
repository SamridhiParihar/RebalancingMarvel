package org.example.thanos_world.heros;


import org.example.thanos_world.superpowers.Flight;
import org.example.thanos_world.superpowers.RepulsorBeams;
import org.example.thanos_world.superpowers.Superpower;
import org.example.thanos_world.weaknesses.SuitDependency;

public class IronMan extends Hero {

    public IronMan() {
        super("Iron Man");

        // Add powers
        addPower(new RepulsorBeams());
        addPower(new Flight());

        // Add weakness
        addWeakness(new SuitDependency());
    }

    @Override
    public void useSignatureAbility() {
        System.out.println("Tony Stark: Jarvis, initiate combat protocol!");
        getSuperpowers().forEach(Superpower::usePower);
    }
}
