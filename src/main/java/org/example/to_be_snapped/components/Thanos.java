package org.example.to_be_snapped.components;

public class Thanos {
    public void fightHero(Hero hero) {
        System.out.println("\nThanos confronts " + hero.name + " at " + hero.name + "'s location...");
        System.out.println(hero.name + " uses their power:");
        hero.usePower();
        System.out.println("But Thanos exploits " + hero.name + "'s weakness:");
        hero.showWeakness();
        System.out.println("Thanos defeats " + hero.name + " and acquires the Infinity Stone!");
    }
}
