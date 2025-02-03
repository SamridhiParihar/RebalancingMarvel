package org.example.thanos_world.heros;

import org.example.thanos_world.superpowers.LightningSummon;
import org.example.thanos_world.superpowers.Superpower;
import org.example.thanos_world.weaknesses.Overconfidence;

public class Thor extends Hero {
    public Thor() {
        super("Thor");
        // Add powers
        addPower(new LightningSummon());
        // Add weakness
        addWeakness(new Overconfidence());
    }

    @Override
    public void useSignatureAbility() {
        System.out.println("Thor: By the power of Mjolnir, I shall smite my foes!");
        getSuperpowers().forEach(Superpower::usePower);
    }
}
