package org.example.thanos_world.weaknesses;

public class SuitDependency implements Weakness {
    @Override
    public void exposeWeakness() {
        System.out.println("Without his suit, he's just a genius billionaire.");
    }
}

