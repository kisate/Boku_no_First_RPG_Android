package com.example.student3.bokunofirstrpg;

import java.util.LinkedList;

/**
 * Created by student3on 26.01.17.
 */
public class Scene {
    String name, description;

    public Scene(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void Launch(){
        System.out.println("Location :" + name);
        System.out.println(description);
        System.out.println("Health : " + Player.hp + " Mana : " + Player.mp + " Gold : " + Player.gold);
        for (Event e: events) {
            System.out.println(e.description);
        }
        GetPlayerChoise();
    }

    LinkedList<Event> events = new LinkedList<Event>();
    void GetPlayerChoise() {
        int choise = Player.MakeChoise(events.size() - 1);
        events.get(choise).Run();
    }
}
