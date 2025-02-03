package org.example.thanos_world.weaknesses;

// for Thanos
public class NoWeakness implements Weakness {
    @Override
    public void exposeWeakness() {
        System.out.println("Thanos has no weaknesses. Perfectly balanced.");
    }
}
