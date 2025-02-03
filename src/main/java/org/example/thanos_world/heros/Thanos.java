package org.example.thanos_world.heros;

import org.example.thanos_world.heros.Hero;
import org.example.thanos_world.infinity_stones.InfinityStone;
import org.example.thanos_world.superpowers.RealityManipulation;
import org.example.thanos_world.superpowers.Superpower;
import org.example.thanos_world.weaknesses.NoWeakness;

import java.util.ArrayList;
import java.util.List;

public class Thanos extends Hero {
    private final List<InfinityStone> gauntlet = new ArrayList<>();

    public Thanos() {
        super("Thanos");
        addPower(new RealityManipulation());
        addWeakness(new NoWeakness());
    }
    

    // Collect stones
    public void collectStone(InfinityStone stone) {
        System.out.println("\n=== Thanos arrives at " + stone.getLocation() + " ===");
        System.out.println("Guardian " + stone.getGuardian().getName() + " activates defense:");
        stone.getGuardian().useSignatureAbility();

        System.out.println("\nThanos overpowers " + stone.getGuardian().getName() + "!");
        gauntlet.add(stone);
        System.out.println("Acquired " + stone.getName() + " | Power: " + stone.getPower());
    }

    // Snap to unleash the power of all stones
    public void snap() {
        if (gauntlet.size() == 6) {
            System.out.println("\n*** SNAP ***");
            gauntlet.forEach(InfinityStone::unleashPower);
            System.out.println("The universe is balanced!");
        } else {
            System.out.println("Thanos needs all 6 stones to snap!");
        }
    }

    @Override
    public void useSignatureAbility() {
        System.out.println("I can do anything I want ");
    }
}
