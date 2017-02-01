package com.example.student3.bokunofirstrpg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Player.hp = 100;
        Player.gold = 0;
        Player.mp = 50;
        LinkedList<Scene> scenes = new LinkedList<Scene>();
        LinkedList<String> lines = new LinkedList<String>();

        LoadLevels(scenes, lines);
        int i = 0;
        while((Player.hp > 0) && (i < scenes.size())) {scenes.get(i).Launch(); i++;}
        if (Player.hp > 0) System.out.println("Congrats");
        else System.out.println("You are dead");
    }

    static void LoadLevels(LinkedList<Scene> scenes, LinkedList<String> lines){
        try {
            File file = new File("a.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String line : lines) {
            if (line.startsWith("Level")) {
                String[] input = line.split("@");
                Scene scene = new Scene(input[1], input[2]);
                String input2[] = input[4].split(":");
                for (int i = 0; i < Integer.parseInt(input[3]); i++) {
                    String[] input3 = input2[i*2 + 1].split(" ");
                    Event event = new Event(Integer.parseInt(input3[0]),Integer.parseInt(input3[1]),Integer.parseInt(input3[2]),input2[i*2]);
                    scene.events.add(event);
                }
                scenes.add(scene);
            }
        }


    }
}
