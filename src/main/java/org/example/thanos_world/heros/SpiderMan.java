package org.example.thanos_world.heros;

import org.example.thanos_world.superpowers.Superpower;
import org.example.thanos_world.superpowers.WebSlinging;
import org.example.thanos_world.weaknesses.Inexperience;

public class SpiderMan extends Hero {
    public SpiderMan() {
        super("Spider-Man");
        // Add powers
        addPower(new WebSlinging());

        // Add weakness
        addWeakness(new Inexperience());
    }

    @Override
    public void useSignatureAbility() {
        System.out.println("Peter Parker: Time to swing into action!");
        getSuperpowers().forEach(Superpower::usePower);
    }
}
