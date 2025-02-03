package org.example.to_be_snapped;


import org.example.to_be_snapped.components.Hero;

import org.example.to_be_snapped.components.InfinityStone;
import org.example.to_be_snapped.components.Location;
import org.example.to_be_snapped.components.Thanos;

public class MarvelWorld {
    public static void main(String[] args) {
        // Create heroes
        Hero ironMan = new Hero("IronMan");
        Hero thor = new Hero("Thor");
        Hero hulk = new Hero("Hulk");
        Hero captainAmerica = new Hero("CaptainAmerica");
        Hero blackWidow = new Hero("BlackWidow");
        Hero spiderMan = new Hero("SpiderMan");
        Hero doctorStrange = new Hero("DoctorStrange");

        // Create locations
        Location avengersTower = new Location("Avengers Tower", "The headquarters of the Avengers.");
        Location asgard = new Location("Asgard", "The home of Thor and the Asgardians.");
        Location wakanda = new Location("Wakanda", "The advanced and hidden kingdom of Black Panther.");
        Location sanctumSanctorum = new Location("Sanctum Sanctorum", "The home of Doctor Strange.");
        Location vormir = new Location("Vormir", "A mysterious planet where the Soul Stone is hidden.");
        Location xandar = new Location("Xandar", "The capital of the Nova Empire.");

        // Create Infinity Stones
        InfinityStone powerStone = new InfinityStone("Power Stone", "Represents the power to manipulate energy.", xandar, captainAmerica);
        InfinityStone timeStone = new InfinityStone("Time Stone", "Represents control over time.", sanctumSanctorum, doctorStrange);
        InfinityStone spaceStone = new InfinityStone("Space Stone", "Represents the ability to manipulate space.", asgard, thor);
        InfinityStone mindStone = new InfinityStone("Mind Stone", "Represents the power to control minds.", avengersTower, ironMan);
        InfinityStone realityStone = new InfinityStone("Reality Stone", "Represents the ability to alter reality.", vormir, blackWidow);
        InfinityStone soulStone = new InfinityStone("Soul Stone", "Represents the power over life and death.", vormir, spiderMan);

        // Display Infinity Stone info
        System.out.println("--- Infinity Stones and Their Guardians ---");

        powerStone.displayInfo();
        timeStone.displayInfo();
        spaceStone.displayInfo();
        mindStone.displayInfo();
        realityStone.displayInfo();
        soulStone.displayInfo();

        // Thanos' quest to collect the stones
        System.out.println("\n--- Thanos' Quest ---");
        Thanos thanos = new Thanos();

        // Thanos fights heroes and collects stones
        thanos.fightHero(powerStone.guardianHero);
        thanos.fightHero(timeStone.guardianHero);
        thanos.fightHero(spaceStone.guardianHero);
        thanos.fightHero(mindStone.guardianHero);
        thanos.fightHero(realityStone.guardianHero);
        thanos.fightHero(soulStone.guardianHero);

        // Thanos collects all stones and deletes the pre-balance world
        System.out.println("\nThanos has collected all six Infinity Stones!");
        System.out.println("With a snap of his fingers, he deletes the pre-balance world and restores balance...");
    }
}
