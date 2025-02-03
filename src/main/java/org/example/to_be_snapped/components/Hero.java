package org.example.to_be_snapped.components;

public class Hero {
    String name;

    public Hero(String name) {
        this.name = name;
    }

    void usePower() {
        if (name.equals("IronMan")) {
            System.out.println("IronMan fires repulsor beams!");
        } else if (name.equals("Thor")) {
            System.out.println("Thor summons lightning!");
        } else if (name.equals("Hulk")) {
            System.out.println("Hulk smashes!");
        } else if (name.equals("CaptainAmerica")) {
            System.out.println("CaptainAmerica throws his indestructible shield!");
        } else if (name.equals("BlackWidow")) {
            System.out.println("BlackWidow uses her elite combat skills!");
        } else if (name.equals("SpiderMan")) {
            System.out.println("SpiderMan shoots webs and swings through the city!");
        } else if (name.equals("DoctorStrange")) {
            System.out.println("DoctorStrange manipulates time and space!");
        } else {
            System.out.println("This hero has no power defined.");
        }
    }

    void showWeakness() {
        if (name.equals("IronMan")) {
            System.out.println("IronMan's weakness: Without his suit, he's just a genius billionaire.");
        } else if (name.equals("Thor")) {
            System.out.println("Thor's weakness: His overconfidence.");
        } else if (name.equals("Hulk")) {
            System.out.println("Hulk's weakness: His anger makes him unpredictable.");
        } else if (name.equals("CaptainAmerica")) {
            System.out.println("CaptainAmerica's weakness: He's a man out of time.");
        } else if (name.equals("BlackWidow")) {
            System.out.println("BlackWidow's weakness: She has no superhuman abilities.");
        } else if (name.equals("SpiderMan")) {
            System.out.println("SpiderMan's weakness: His youth and inexperience.");
        } else if (name.equals("DoctorStrange")) {
            System.out.println("DoctorStrange's weakness: His arrogance can cloud his judgment.");
        } else {
            System.out.println("This hero's weakness is unknown.");
        }
    }

    public String getName() {
        return name;
    }
}
